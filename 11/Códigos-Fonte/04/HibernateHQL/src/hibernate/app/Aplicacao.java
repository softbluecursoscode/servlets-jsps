package hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.Cliente;
import hibernate.Livro;
import hibernate.RG;

public class Aplicacao {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		//selecionar todos os livros cadastrados
		{
			String hql = "FROM Livro";
			
			Query<Livro> q = session.createQuery(hql);
			
			List<Livro> result = q.getResultList();
			
			for (Livro l : result) {
				System.out.println("Nome: " + l.getNome());
				System.out.println("Autor: " + l.getAutor());
				System.out.println("Editora: " + l.getEditora().getNome());
			}
		}
		
		//selecionar o ISBN e nome de todos os livros cadastrados
		{
			String hql = "SELECT l.isbn, l.nome FROM Livro l";
			Query<Object[]> q = session.createQuery(hql);
			List<Object[]> result = q.getResultList();
			
			for (Object[] obj : result) {
				System.out.println("ISBN: " + obj[0]);
				System.out.println("Nome: " + obj[1]);
			}
		}
		
		//selecionar todos os clientes que emprestaram livros
		{
			String hql = "SELECT c FROM Cliente c INNER JOIN c.livros l";
			Query<Cliente> q = session.createQuery(hql);
			List<Cliente> result = q.getResultList();
			
			for (Cliente c : result) {
				System.out.println("Nome:" + c.getNome());
				System.out.println("RG: " + c.getRg().getNumero());
			}
		}
		
		//selecionar todos os livros cujo nome da editora e' 'Editora 1'
		{
			String hql = "SELECT l FROM Livro l WHERE l.editora.nome = 'Editora 1'";
			Query<Livro> q = session.createQuery(hql);
			List<Livro> result = q.getResultList();
			
			for (Livro l : result) {
				System.out.println("Nome: " + l.getNome());
			}
		}
		
		//selecionar todos os RGs de clientes cujo nome comeca com 'C'
		{
			String hql = "SELECT r FROM RG r WHERE r.cliente.nome LIKE 'C%'";
			Query<RG> q = session.createQuery(hql);
			List<RG> result = q.getResultList();
			
			for (RG rg : result) {
				System.out.println("N: " + rg.getNumero());
			}
		}
		
		session.getTransaction().commit();
	}

}
