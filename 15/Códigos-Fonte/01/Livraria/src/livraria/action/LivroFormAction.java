package livraria.action;

import livraria.entity.Livro;
import livraria.service.LivroService;
import webf.action.Action;

/**
 * Abre o formulário de cadastro de livros
 */
public class LivroFormAction extends Action {

	@Override
	public void process() throws Exception {

		String livroId = getRequest().getParameter("id");
		
		if (livroId != null) {
			// Se um ID for passado como parâmetro, significa que um livro está sendo aberto para edição.
			// Busca os dados do livro na base de dados para exibir no formulário
			
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
