package livraria.dao;

import java.util.List;

import org.hibernate.query.Query;

import livraria.entity.Pedido;
import livraria.entity.Usuario;
import webf.dao.DAO;
import webf.dao.DAOException;

public class PedidoDAO extends DAO<Pedido> {

	public PedidoDAO() {
		super(Pedido.class);
	}

	/**
	 * Obtém o maior sequencial de número de pedido
	 * @return
	 * @throws DAOException
	 */
	public int getMaxNumPedido() throws DAOException {
		List<String> result = (List<String>) list("SELECT MAX(p.id) FROM Pedido p", String.class);
		
		String max = result.get(0);
		
		if (max == null) {
			// Não existem pedidos cadastrados
			return 0;
		}
		
		return Integer.parseInt(max);
	}
	
	/**
	 * Obtém os pedidos atrelados a um usuário
	 * @param usuario
	 * @return
	 * @throws DAOException
	 */
	public List<Pedido> getPedidosByUsuario(Usuario usuario) throws DAOException {
		Query<Pedido> q = query("FROM Pedido p WHERE p.usuario.id = :usuarioId ORDER BY p.data DESC");
		q.setParameter("usuarioId", usuario.getId());
		List<Pedido> result = q.list();
		return result;
	}
	
	/**
	 * Obtém os pedidos que estão com determinado status
	 * @param status
	 * @return
	 * @throws DAOException
	 */
	public List<Pedido> getPedidosByStatus(int status) throws DAOException {
		Query<Pedido> q = query("FROM Pedido p WHERE p.status = :status ORDER BY p.data");
		q.setParameter("status",status);
		List<Pedido> result = q.list();
		return result;
	}
}
