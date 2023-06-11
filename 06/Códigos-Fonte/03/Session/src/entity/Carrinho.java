package entity;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private List<Produto> produtos = new ArrayList<Produto>();
	
	public void add(Produto p) {
		produtos.add(p);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
}
