package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Exemplo {

	public static void main(String[] args) throws Exception {
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		Produto p = new Produto();
		p.setNome("P1");
		
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
		System.out.println(p.getId());
	}
}
