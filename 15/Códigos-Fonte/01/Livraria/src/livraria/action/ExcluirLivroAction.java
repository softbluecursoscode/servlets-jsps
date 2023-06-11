package livraria.action;

import livraria.service.LivroService;
import webf.action.Action;

/**
 * Exclui um livro
 */
public class ExcluirLivroAction extends Action {

	@Override
	public void process() throws Exception {

		String livroId = getRequest().getParameter("id");
		
		LivroService livroService = serviceFactory.getService(LivroService.class);
		livroService.excluir(Integer.parseInt(livroId));

		redirect("admin/ListarLivros.action");
	}
}
