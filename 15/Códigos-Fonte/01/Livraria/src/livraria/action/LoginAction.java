package livraria.action;

import livraria.entity.Usuario;
import livraria.service.UsuarioService;
import webf.action.Action;
import webf.util.StringUtils;

/**
 * Realiza o login do usuário
 */
public class LoginAction extends Action {

	@Override
	public void process() throws Exception {
		
		String email = getRequest().getParameter("email").trim();
		String senha = getRequest().getParameter("senha").trim();
		
		// Verifica se o e-mail e senha foram preenchidos adequadamente
		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(senha)) {
			getRequest().setAttribute("erro", "É preciso fornecer um usuário e senha");
			getRequest().setAttribute("email", email);
			getRequest().setAttribute("senha", senha);
			forward("login.jsp");
			return;
		}
		
		UsuarioService usuarioService = serviceFactory.getService(UsuarioService.class);
		Usuario usuario = usuarioService.login(email, senha);
		
		// Se retornou null, o usuário não foi encontrado ou nao pode ser autenticado
		if (usuario == null) {
			getRequest().setAttribute("erro", "Usuário/senha não encontrado");
			getRequest().setAttribute("email", email);
			getRequest().setAttribute("senha", senha);
			forward("login.jsp");
			return;
		}
		
		// Coloca o usuário na sessão
		getSession().setAttribute("usuario", usuario);
		
		redirect("usuario_logado.jsp");
	}
}
