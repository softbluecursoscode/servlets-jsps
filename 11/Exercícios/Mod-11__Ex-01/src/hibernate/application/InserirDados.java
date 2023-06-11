package hibernate.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Candidato;
import hibernate.entity.Cargo;
import hibernate.entity.Eleitor;
import hibernate.entity.Voto;

/*
 * Classe responsável por inserir os dados no banco de dados
 */
public class InserirDados {

	public static void main(String[] args) throws Exception {
		
		//inicializa o Hibernate
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.getCurrentSession();
		
		//inicia uma transação
		session.beginTransaction();
		
		// ----- Cargos ---- //
		Cargo cargo1 = new Cargo();
		cargo1.setNome("Presidente");
		session.save(cargo1);
		
		Cargo cargo2 = new Cargo();
		cargo2.setNome("Prefeito");
		session.save(cargo2);
		
		Cargo cargo3 = new Cargo();
		cargo3.setNome("Senador");
		session.save(cargo3);
		
		// ----- Candidatos ---- //
		Candidato cand1 = new Candidato();
		cand1.setNome("José Santos");
		cand1.setCargo(cargo1);
		session.save(cand1);
		
		Candidato cand2 = new Candidato();
		cand2.setNome("Osmar Aquino");
		cand2.setCargo(cargo1);
		session.save(cand2);
		
		Candidato cand3 = new Candidato();
		cand3.setNome("Matias Rizon");
		cand3.setCargo(cargo2);
		session.save(cand3);
		
		Candidato cand4 = new Candidato();
		cand4.setNome("Marcos Silva");
		cand4.setCargo(cargo2);
		session.save(cand4);
		
		Candidato cand5 = new Candidato();
		cand5.setNome("André Costa");
		cand5.setCargo(cargo3);
		session.save(cand5);
		
		Candidato cand6 = new Candidato();
		cand6.setNome("Ramon Teixeira");
		cand6.setCargo(cargo3);
		session.save(cand6);
		
		// ----- Eleitores ---- //
		Eleitor eleitor1 = new Eleitor();
		eleitor1.setTituloEleitor("56723");
		eleitor1.setNome("Rafael Jamelka");
		session.save(eleitor1);
		
		Eleitor eleitor2 = new Eleitor();
		eleitor2.setTituloEleitor("89192");
		eleitor2.setNome("Murilo Dias");
		session.save(eleitor2);
		
		Eleitor eleitor3 = new Eleitor();
		eleitor3.setTituloEleitor("12648");
		eleitor3.setNome("Luis Kirk");
		session.save(eleitor3);
		
		// ----- Votos ---- //
		Voto voto1 = new Voto();
		voto1.setEleitor(eleitor1);
		voto1.setCandidato(cand1);
		session.save(voto1);
		
		Voto voto2 = new Voto();
		voto2.setEleitor(eleitor1);
		voto2.setCandidato(cand3);
		session.save(voto2);
		
		Voto voto3 = new Voto();
		voto3.setEleitor(eleitor1);
		voto3.setCandidato(cand5);
		session.save(voto3);
		
		Voto voto4 = new Voto();
		voto4.setEleitor(eleitor2);
		voto4.setCandidato(cand2);
		session.save(voto4);
		
		Voto voto5 = new Voto();
		voto5.setEleitor(eleitor2);
		voto5.setCandidato(cand3);
		session.save(voto5);
		
		Voto voto6 = new Voto();
		voto6.setEleitor(eleitor2);
		voto6.setCandidato(cand6);
		session.save(voto6);
		
		Voto voto7 = new Voto();
		voto7.setEleitor(eleitor3);
		voto7.setCandidato(cand1);
		session.save(voto7);
		
		Voto voto8 = new Voto();
		voto8.setEleitor(eleitor3);
		voto8.setCandidato(cand4);
		session.save(voto8);
		
		Voto voto9 = new Voto();
		voto9.setEleitor(eleitor3);
		voto9.setCandidato(cand5);
		session.save(voto9);
		
		//finaliza a transação
		session.getTransaction().commit();
	}
}
