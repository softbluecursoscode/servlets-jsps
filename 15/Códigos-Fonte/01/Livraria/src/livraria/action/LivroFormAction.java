package livraria.action;

import livraria.entity.Livro;
import livraria.service.LivroService;
import webf.action.Action;

/**
 * Abre o formul�rio de cadastro de livros
 */
public class LivroFormAction extends Action {

	@Override
	public void process() throws Exception {

		String livroId = getRequest().getParameter("id");
		
		if (livroId != null) {
			// Se um ID for passado como par�metro, significa que um livro est� sendo aberto para edi��o.
			// Busca os dados do livro na base de dados para exibir no formul�rio
			
			LivroService livroService = serviceFactory.getService(LivroService.class);
			Livro livro = livroService.getLivroById(Integer.parseInt(livroId));
			
			getRequest().setAttribute("id", livro.getId());
			getRequest().setAttribute("titulo", livro.getTitulo());
			getRequest().setAttribute("autor", livro.getAutor());
			getRequest().setAttribute("editora", livro.getEditora());
			getRequest().setAttribute("ano", livro.getAno());
			getRequest().setAttribute("preco", livro.getPreco());
		}
		
		forward("livro.jsp");
	}
}
