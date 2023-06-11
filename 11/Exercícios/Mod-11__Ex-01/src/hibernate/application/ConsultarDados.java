package hibernate.application;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Candidato;

/*
 * Classe responsável por ler algumas informações cadastradas no banco de dados.
 * Para que o método main() funcione, os dados devem estar previamente cadastrados.
 */
public class ConsultarDados {

	public static void main(String[] args) throws Exception {
		
		//inicializa o Hibernate
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.getCurrentSession();
		
		//inicia uma transação
		session.beginTransaction();
		
		//lista os candidatos à presidente
		mostrarCandidatosECargos(session);
		System.out.println();
		
		//lista os votos de um eleitor
		mostrarVotosDoEleitor(session);
		System.out.println();
		
		//mostra cada candidato e a quantidade de votos que recebeu
		mostrarVotosPorCandidato(session);
		System.out.println();
		
		//finaliza a transação
		session.getTransaction().commit();
	}

	/*
	 * Imprime a lista dos candidatos a presidente
	 */
	@SuppressWarnings("unchecked")
	private static void mostrarCandidatosECargos(Session session) {
		String hql = "FROM Candidato c WHERE c.cargo.nome = 'Presidente' ORDER BY c.nome";
		
		Query<Candidato> q = session.createQuery(hql);
		List<Candidato> r = q.getResultList();
		
		for (Candidato c : r) {
			System.out.println("Nome Candidato a Presidente: " + c.getNome());
		}
	}
	
	/*
	 * Imprime a lista dos candidatos em quem o eleitor cujo título é 56723 votou	
	 */
	@SuppressWarnings("unchecked")
	private static void mostrarVotosDoEleitor(Session session) {
		String hql = "SELECT v.candidato FROM Voto v WHERE v.eleitor.tituloEleitor = '56723'";
		
		Query<Candidato> q = session.createQuery(hql);
		List<Candidato> r = q.getResultList();
		
		for (Candidato c : r) {
			System.out.println("Candidato votado: " + c.getNome() + " (" + c.getCargo().getNome() + ")");
		}
	}
	
	/*
	 * Imprime o nome de cada candidato votado e quantos votos ele recebeu
	 */
	@SuppressWarnings("unchecked")
	private static void mostrarVotosPorCandidato(Session session) {
		String hql = "SELECT c.nome, COUNT(*) FROM Voto v INNER JOIN v.candidato c GROUP BY c.nome";
		
		Query<Object[]> q = session.createQuery(hql);
		List<Object[]> r = q.getResultList();
		
		for (Object[] obj : r) {
			String nomeCandidato = (String)obj[0];
			long numVotos = (Long)obj[1];
			
			System.out.println("Nome: " + nomeCandidato + ", Votos: " + numVotos);
		}
	}
}
