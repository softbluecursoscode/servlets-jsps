package livraria.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import livraria.dao.PedidoDAO;
import livraria.entity.Livro;
import livraria.entity.Pedido;
import livraria.entity.Usuario;
import webf.dao.DAOException;
import webf.service.Service;
import webf.service.ServiceException;

public class PedidoService extends Service {
	
	// Status que um pedido pode assumir
	public static final int STATUS_ANALISE = 1;
	public static final int STATUS_APROVADO = 2;
	public static final int STATUS_CANCELADO = 3;
	
	// Descri��o dos status
	public static final String STATUS_DESC_ANALISE = "Em an�lise";
	public static final String STATUS_DESC_APROVADO = "Aprovado";
	public static final String STATUS_DESC_CANCELADO = "Cancelado";

	/**
	 * Finaliza um pedido
	 * @param usuario
	 * @param itens
	 * @return
	 * @throws ServiceException
	 */
	public String fecharPedido(Usuario usuario, Set<Livro> itens) throws ServiceException {
		try {
			PedidoDAO pedidoDAO = daoFactory.getDAO(PedidoDAO.class);
			
			// Gera um n�mero para o novo pedido
			String numPedido = gerarNumPedido();
			
			// Cria o objeto do pedido
			Pedido pedido = new Pedido();
			pedido.setId(numPedido);
			pedido.setData(new Date());
			pedido.setUsuario(usuario);
			pedido.setStatus(STATUS_ANALISE);
			
			// Calcula o valor total do pedido (soma os valores dos itens)
			double valor = 0.0;
			for (Livro livro : itens) {
				valor += livro.getPreco();
			}
			pedido.setValor(valor);
			
			// Grava o pedido
			pedidoDAO.save(pedido);
			
			// Adiciona os livros ao pedido (relacionamento um-para-muitos)
			for (Livro livro : itens) {
				pedido.getLivros().add(livro);
			}
			
			// Retorna o n�mero do pedido rec�m gerado
			return numPedido;
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Retorna todos os pedidos de um usu�rio
	 * @param usuario
	 * @return
	 * @throws ServiceException
	 */
	public List<Pedido> getPedidosByUsuario(Usuario usuario) throws ServiceException {
		try {
			PedidoDAO pedidoDAO = daoFactory.getDAO(PedidoDAO.class);
			return pedidoDAO.getPedidosByUsuario(usuario);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Retorna pedidos com base no status
	 * @param status
	 * @return
	 * @throws ServiceException
	 */
	public List<Pedido> getPedidosByStatus(int status) throws ServiceException {
		try {
			PedidoDAO pedidoDAO = daoFactory.getDAO(PedidoDAO.class);
			return pedidoDAO.getPedidosByStatus(status);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Atualiza os status dos pedidos
	 * @param statusMap
	 * @throws ServiceException
	 */
	public void atualizarStatus(Map<String, Integer> statusMap) throws ServiceException {
		try {
			PedidoDAO pedidoDAO = daoFactory.getDAO(PedidoDAO.class);
			
			// O map mapeia um n�mero de pedido a um status
			for (Map.Entry<String, Integer> entry : statusMap.entrySet()) {
				String numPedido = entry.getKey();
				int status = entry.getValue();
				
				// Carrega o pedido
				Pedido pedido = pedidoDAO.load(numPedido);
				
				// Verifica se houve mudan�a de status. Se houve, altera na base de dados
				if (status != pedido.getStatus()) {
					pedido.setStatus(status);
				}
			}
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Gera um n�mero de pedido
	 * @return
	 * @throws ServiceException
	 */
	private String gerarNumPedido() throws ServiceException {
		try {
			PedidoDAO pedidoDAO = daoFactory.getDAO(PedidoDAO.class);
			
			// Obt�m o maior sequencial de n�mero de pedido cadastrado
			int max = pedidoDAO.getMaxNumPedido();
			
			// Incrementa em 1 e preenche com 0's � esquerda
			int proximo = max + 1;
			String numPedido = String.format("%06d", proximo);
			
			return numPedido;
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
