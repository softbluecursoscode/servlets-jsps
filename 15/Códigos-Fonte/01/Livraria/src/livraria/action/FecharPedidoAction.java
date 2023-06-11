package livraria.action;

import java.util.Set;

import livraria.entity.Livro;
import livraria.entity.Usuario;
import livraria.helper.Carrinho;
import livraria.service.PedidoService;
import webf.action.Action;

/**
 * Fecha um pedido
 */
public class FecharPedidoAction extends Action {

	@Override
	public void process() throws Exception {
		
		Carrinho carrinho = (Carrinho) getSession().getAttribute("carrinho");
		Usuario usuario = (Usuario) getSession().getAttribute("usuario");
		
		PedidoService pedidoService = serviceFactory.getService(PedidoService.class);
		Set<Livro> livros = carrinho.getLivros();
		
		pedidoService.fecharPedido(usuario, livros);
		
		getSession().setAttribute("carrinho", null);
		redirect("pedido_efetuado.jsp");
	}
}
