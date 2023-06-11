package livraria.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import livraria.service.PedidoService;
import webf.action.Action;
import webf.util.StringUtils;

/**
 * Processa pedidos em análise
 */
public class ProcessarPedidosAction extends Action {

	@Override
	public void process() throws Exception {
		
		// Obtém os pedidos e status selecionados na etla
		Map<String, Integer> statusMap = getStatusPedidos();
		
		// Atualiza os dados
		PedidoService pedidoService = (PedidoService) serviceFactory.getService(PedidoService.class);
		pedidoService.atualizarStatus(statusMap);
		
		redirect("admin/GerenciarPedidos.action");
	}
	
	/**
	 * Obtém os status dos pedidos.
	 * @return Um map mapeando um número de pedido a um status
	 */
	private Map<String, Integer> getStatusPedidos() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// Itera sobre todos os parâmetros vindos na request
		Enumeration<String> params = getRequest().getParameterNames();
		
		while (params.hasMoreElements()) {
			String param = params.nextElement();
			if (param.startsWith("status_")) {
				// Se o parâmetro começa com 'status_', é um combo box de stauts
				
				// Extrai o ID do pedido
				String id = param.substring(7);
				
				// Obtém o status
				String statusStr = getRequest().getParameter(param);
				
				// Se o valor do parâmetro está vazio, significa que o pedido não deve ser processado
				if (!StringUtils.isEmpty(statusStr)) {
					int status = Integer.parseInt(statusStr);
					map.put(id, status);
				}
			}
		}
		return map;
	}
}
