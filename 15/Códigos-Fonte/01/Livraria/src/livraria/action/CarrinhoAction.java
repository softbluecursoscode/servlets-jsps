package livraria.action;

import livraria.entity.Livro;
import livraria.helper.Carrinho;
import livraria.service.LivroService;
import webf.action.Action;

/**
 * Adiciona um livro no carrinho
 */
public class CarrinhoAction extends Action {

	@Override
	public void process() throws Exception {
		LivroService livroService = serviceFactory.getService(LivroService.class);
	
		Carrinho carrinho = (Carrinho) getSession().getAttribute("carrinho");
		if (carrinho == null) {
			// Se um carrinho ainda não existe, cria
			carrinho = new Carrinho();
			getSession().setAttribute("carrinho", carrinho);
		}
		
		String op = getRequest().getParameter("op");
		String livroId = getRequest().getParameter("id");
		
		// O parâmetro 'op' indica se é para inserir ou remover um item
		
		if (op != null && op.equals("inserir") && livroId != null) {
			Livro livro = livroService.getLivroById(Integer.parseInt(livroId));
			carrinho.adicionarItem(livro);
		
		} else if (op != null && op.equals("remover") && livroId != null) {
			carrinho.removerItem(Integer.parseInt(livroId));
		}
		
		getSession().setAttribute("menuAtivo", "carrinho");
		forward("carrinho.jsp");
	}
}
