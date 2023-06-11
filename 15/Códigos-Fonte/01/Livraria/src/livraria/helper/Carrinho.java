package livraria.helper;

import java.util.LinkedHashSet;
import java.util.Set;

import livraria.entity.Livro;

/**
 * Representa o carrinho de compras
 */
public class Carrinho {

	// As duas coleções são gerenciadas simultaneamente. Uma tem objetos view, e a outra objetos entity.
	// Ambas são Set, para evitar que livros iguais possam ser adicionados mais de uma vez no carrinho.
	private Set<Livro> livros = new LinkedHashSet<Livro>();
	
	/**
	 * Adiciona um livro ao carrinho
	 * @param livro
	 */
	public void adicionarItem(Livro livro) {
		livros.add(livro);
	}
	
	/**
	 * Remove um livro do carrinho
	 * @param livroId
	 */
	public void removerItem(Integer livroId) {
		Livro livro = new Livro();
		livro.setId(livroId);
		livros.remove(livro);
	}
	
	
	/**
	 * Obtém o valor total do carrinho, somando os valores dos itens
	 * @return
	 */
	public Double getValorTotal() {
		double total = 0.0;
		for (Livro livro : livros) {
			total += livro.getPreco();
		}
		
		return total;
	}
	
	public Set<Livro> getItens() {
		return livros; 
	}
	
	public Set<Livro> getLivros() {
		return livros;
	}
}
