package livraria.action;

import java.util.ArrayList;
import java.util.List;

import livraria.entity.Pedido;
import livraria.service.PedidoService;
import livraria.view.PedidoView;
import webf.action.Action;

/**
 * Gerencia os pedidos
 */
public class GerenciarPedidosAction extends Action {

	@Override
	public void process() throws Exception {
		getSession().setAttribute("menuAtivo", "pedidos");
		
		PedidoService pedidoService = (PedidoService) serviceFactory.getService(PedidoService.class);
		
		// Obtém uma lista dos pedidos em análise
		List<Pedido> pedidos = pedidoService.getPedidosByStatus(PedidoService.STATUS_ANALISE);
		
		// Cria uma lista de PedidosView
		List<PedidoView> pedidosView = new ArrayList<PedidoView>();
		for (Pedido pedido : pedidos) {
			pedidosView.add(new PedidoView(pedido));
		}
		
		getRequest().setAttribute("pedidos", pedidosView);
		
		forward("pedidos_abertos.jsp");
	}
}
