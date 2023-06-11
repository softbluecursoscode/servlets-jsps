package livraria.action;

import java.util.ArrayList;
import java.util.List;

import livraria.entity.Usuario;
import livraria.service.UsuarioService;
import webf.action.Action;
import webf.util.StringUtils;

/**
 * Cadastra um novo usu�rio no sistema
 */
public class CadastrarUsuarioAction extends Action {

	@Override
	public void process() throws Exception {
		
		String email = getRequest().getParameter("email");
		
		if (email == null) {
			// Se o par�metro 'email' n�o existe � porque o usu�rio abriu a tela para preencher o formul�rio
			forward("cadastrar_usuario.jsp");
			return;
		}
		
		// Extrai os dados digitados no formul�rio
		email = email.trim();
		String nome = getRequest().getParameter("nome").trim();
		String senha1 = getRequest().getParameter("senha1").trim();
		String senha2 = getRequest().getParameter("senha2").trim();
		
		// Faz a valida��o dos dados digitados
		validarEmail(email);
		validarNome(nome);
		validarSenha(senha1, senha2);
		
		// Caso tenha ocorrido algum erro de valida��o, coloca as informa��es novamente na request (para permitir que o formul�rio
		// exiba os campos preenchidos) e volta para a mesma tela.
		if (existemErros()) {
			definirValores(email, nome, senha1, senha2);
			forward("cadastrar_usuario.jsp");
			return;
		}
		
		// Cria o objeto que representa o usu�rio
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setSenha(senha1);
		
		UsuarioService usuarioService = serviceFactory.getService(UsuarioService.class);
		
		// Grava o usu�rio
		boolean sucesso = usuarioService.salvar(usuario);
		if (!sucesso) {
			// O usu�rio j� existe. Recoloca os valores na request e volta para a pr�pria tela
			adicionarErro("Usu�rio j� existe");
			definirValores(email, nome, senha1, senha2);
			forward("cadastrar_usuario.jsp");
			return;
		}
		
		redirect("usuario_cadastrado.jsp");
	}
	
	/**
	 * Coloca os valores submetidos pelo formul�rio novamente na request, para que possam ser exibidos novamente ap�s o 
	 * carregamento da p�gina
	 * @param email
	 * @param nome
	 * @param senha1
	 * @param senha2
	 */
	private void definirValores(String email, String nome, String senha1, String senha2) {
		getRequest().setAttribute("email", email);
		getRequest().setAttribute("nome", nome);
		getRequest().setAttribute("senha1", senha1);
		getRequest().setAttribute("senha2", senha2);
	}
	
	/**
	 * Valida o e-mail
	 * @param email
	 */
	private void validarEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			adicionarErro("O e-mail � obrigat�rio");
		}
		
		if (email.length() > 50) {
			adicionarErro("O e-mail digitado � muito grande");
		}
		
		// Valida com base em uma express�o regular
		if (!email.matches("\\w+@\\w+\\.\\w+")) {
			adicionarErro("O e-mail digitado n�o tem formato v�lido");
		}
	}
	
	/**
	 * Valida o nome
	 * @param nome
	 */
	private void validarNome(String nome) {
		if (StringUtils.isEmpty(nome)) {
			adicionarErro("O nome � obrigat�rio");
		}
		
		if (nome.length() > 50) {
			adicionarErro("O nome digitado � muito grande");
		}
	}
	
	/**
	 * Valida a senha e verifica se ambas as senhas digitadas s�o iguais
	 * @param senha1
	 * @param senha2
	 */
	private void validarSenha(String senha1, String senha2) {
		if (StringUtils.isEmpty(senha1)) {
			adicionarErro("A senha � obrigat�ria");
		}
		
		if (senha1.length() > 20) {
			adicionarErro("O senha digitada � muito grande");
		}
		
		if (StringUtils.isEmpty(senha2)) {
			adicionarErro("A confirma��o de senha � obrigat�ria");
		}
		
		if (senha2.length() > 20) {
			adicionarErro("O confirma��o de senha digitada � muito grande");
		}
		
		if (!senha1.equals(senha2)) {
			adicionarErro("As senhas digitadas s�o diferentes");
		}
	}
	
	/**
	 * Adiciona um erro de valida��o na request. Isto � feito atrav�s da coloca��o de uma list de erros na request
	 * @param erro
	 */
	@SuppressWarnings("unchecked")
	private void adicionarErro(String erro) {
		List<String> erros = (List<String>) getRequest().getAttribute("erros");
		if (erros == null) {
			erros = new ArrayList<String>();
			getRequest().setAttribute("erros", erros);
		}
		
		erros.add(erro);
	}
	
	/**
	 * Verifica se existem erros de valida��o
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean existemErros() {
		List<String> erros = (List<String>) getRequest().getAttribute("erros");
		if (erros == null || erros.size() == 0) {
			return false;
		}
		return true;
	}
}
