package livraria.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import livraria.dao.LivroDAO;
import livraria.entity.Livro;
import webf.dao.DAOException;
import webf.service.Service;
import webf.service.ServiceException;
import webf.util.StringUtils;

public class LivroService extends Service {

	/**
	 * Cria/atualiza um livro
	 * @param livro
	 * @throws ServiceException
	 */
	public void salvar(Livro livro) throws ServiceException {
		try {
			LivroDAO livroDAO = daoFactory.getDAO(LivroDAO.class);
			
			if (livro.getId() == null) {
				// se o ID for nulo, é porque o livro ainda não existe
				livroDAO.save(livro);
			} else {
				livroDAO.update(livro);
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Exclui um livro
	 * @param livroId
	 * @throws ServiceException
	 */
	public void excluir(Integer livroId) throws ServiceException {
		try {
			LivroDAO livroDAO = daoFactory.getDAO(LivroDAO.class);
			
			// Se o livro estiver atrelado a um pedido, não é possível excluí-lo.
			boolean livroEmPedido = livroDAO.isLivroEmPedido(livroId);
			
			if (livroEmPedido) {
				throw new ReferencedEntityException("O livro " + livroId + " está sendo referenciado em algum pedido");
			}
			
			// Carrega o livro e exclui
			Livro livro = livroDAO.load(livroId);
			livroDAO.delete(livro);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Pesquisa livros a partir de parte do título ou autor.
	 * @param titulo
	 * @param autor
	 * @return
	 * @throws ServiceException
	 */
	public List<Livro> pesquisarLivros(String titulo, String autor) throws ServiceException {
		try {
			// Os livros são colocados em um Set para evitar que existam resultados duplicados na pesquisa
			Set<Livro> livros = new LinkedHashSet<Livro>();
			
			LivroDAO livroDAO = daoFactory.getDAO(LivroDAO.class);
			
			if (!StringUtils.isEmpty(titulo)) {
				// Pesquisa primeiro por título
				livros.addAll(livroDAO.getLivrosByTitulo(titulo));
			}
			
			if (!StringUtils.isEmpty(autor)) {
				// Depois pesquisa por autor
				livros.addAll(livroDAO.getLivrosByAutor(autor));
			}
			
			return new ArrayList<Livro>(livros);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Obtém um livro com base no seu ID
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public Livro getLivroById(Integer id) throws ServiceException {
		try {
			LivroDAO livroDAO = daoFactory.getDAO(LivroDAO.class);
			return livroDAO.getLivroById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	/**
	 * Retorna todos os livros cadastrados
	 * @return
	 * @throws ServiceException
	 */
	public List<Livro> getLivros() throws ServiceException {
		try {
			LivroDAO livroDAO = daoFactory.getDAO(LivroDAO.class);
			return livroDAO.getLivros();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
