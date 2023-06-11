package livraria.dao;

import java.util.List;

import org.hibernate.query.Query;

import livraria.entity.Livro;
import webf.dao.DAO;
import webf.dao.DAOException;

public class LivroDAO extends DAO<Livro> {

	public LivroDAO() {
		super(Livro.class);
	}

	/**
	 * Obtém os livros com determinado título (parte dele)
	 * @param titulo
	 * @return
	 * @throws DAOException
	 */
	public List<Livro> getLivrosByTitulo(String titulo) throws DAOException {
		Query<Livro> q = query("FROM Livro l WHERE upper(l.titulo) like :titulo order by l.titulo");
		q.setParameter("titulo", "%" + titulo.toUpperCase() + "%");
		return q.getResultList();
	}
	
	/**
	 * Obtém os livros com determinado autor (parte dele)
	 * @param autor
	 * @return
	 * @throws DAOException
	 */
	public List<Livro> getLivrosByAutor(String autor) throws DAOException {
		Query<Livro> q = query("FROM Livro l WHERE upper(l.autor) like :autor order by l.autor");
		q.setParameter("autor", "%" + autor.toUpperCase() + "%");
		return q.list();
	}
	
	/**
	 * Obtém o livro com determinado ID
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	public Livro getLivroById(Integer id) throws DAOException {
		Query<Livro> q = query("FROM Livro l WHERE l.id = :id");
		q.setParameter("id", id);
		return (Livro) q.uniqueResult();
	}
	
	/**
	 * Obtém todos os livros cadastrados, ordenados por título
	 * @return
	 * @throws DAOException
	 */
	public List<Livro> getLivros() throws DAOException {
		return (List<Livro>) list("FROM Livro l ORDER BY l.titulo");
	}

	/**
	 * Verifica se determinado livro faz parte de algum pedido
	 * @param livroId
	 * @return
	 * @throws DAOException
	 */
	public boolean isLivroEmPedido(Integer livroId) throws DAOException {
		Query<Long> q = query("SELECT COUNT(*) FROM Pedido p INNER JOIN p.livros AS l WHERE l.id = :livroId", Long.class);
		q.setParameter("livroId", livroId);
		Long count = (Long) q.uniqueResult();
		return count > 0;
	}
}
