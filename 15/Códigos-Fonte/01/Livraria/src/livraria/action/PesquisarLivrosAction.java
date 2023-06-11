package livraria.action;

import java.util.List;

import livraria.entity.Livro;
import livraria.service.LivroService;
import webf.action.Action;

/**
 * Pesquisa livros cadastrados
 */
public class PesquisarLivrosAction extends Action {

	@Override
	public void process() throws Exception {
		
		String titulo = getRequest().getParameter("titulo");
		String autor = getRequest().getParameter("autor");
		
		if (titulo == null && autor == null) {
			// Se autor e título não foram passados, abre a tela para pesquisa
			getSession().setAttribute("menuAtivo", "livros");
			forward("pesquisar_livros.jsp");
			return;
		}
		
		// Realiza a pesquisa
		LivroService livroService = serviceFactory.getService(LivroService.class);
		List<Livro> livros = livroService.pesquisarLivros(titulo, autor);
		
		// Coloca a lista de livros pesquisados na request
		getRequest().setAttribute("livros", livros);
		forward("pesquisar_livros.jsp");
	}
}
