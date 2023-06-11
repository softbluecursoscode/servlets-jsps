package livraria.tools;

import livraria.dao.LivroDAO;
import livraria.dao.UsuarioDAO;
import livraria.entity.Livro;
import livraria.entity.Usuario;
import webf.dao.DAOFactory;
import webf.util.HibernateUtil;

public class DBCreator {
	
	public static void main(String[] args) throws Exception {
		insertData();
	}

	private static void insertData() throws Exception {

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			HibernateUtil.beginTransaction();

			LivroDAO livroDAO = daoFactory.getDAO(LivroDAO.class);
			UsuarioDAO usuarioDAO = daoFactory.getDAO(UsuarioDAO.class);
			
			Livro l = new Livro();
			l.setTitulo("Use a Cabeça! - Java");
			l.setAutor("Kathy Sierra");
			l.setAno(2007);
			l.setPreco(129.9);
			l.setEditora("Starlin Alta Consult");
			livroDAO.save(l);
			
			l = new Livro();
			l.setTitulo("Java - Como Programar");
			l.setAutor("Harvey Deitel");
			l.setAno(2010);
			l.setPreco(249.0);
			l.setEditora("Prentice Hall Brasil");
			livroDAO.save(l);
			
			l = new Livro();
			l.setTitulo("Java 7");
			l.setAutor("Herbert Schildt");
			l.setAno(2011);
			l.setPreco(159.1);
			l.setEditora("Osborne - McGraw-Hil");
			livroDAO.save(l);
			
			l = new Livro();
			l.setTitulo("Java Persistence com Hibernate");
			l.setAutor("Christian Bauer");
			l.setAno(2007);
			l.setPreco(135.0);
			l.setEditora("Ciência Moderna");
			livroDAO.save(l);
			
			Usuario u = new Usuario();
			u.setNome("José Silva");
			u.setEmail("jose@silva.com");
			u.setSenha("1");
			usuarioDAO.save(u);

			HibernateUtil.commitTransaction();
		} catch (Exception e) {
			HibernateUtil.rollbackTransaction();
			throw e;
		}
	}
}
