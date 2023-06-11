package dao;

import java.util.List;

import entity.Sala;

@SuppressWarnings("unchecked")
public class SalaDAO extends DAO<Sala> {

	public SalaDAO() {
		super(Sala.class);
	}
	
	public List<Sala> getSalas() throws DAOException {
		return (List<Sala>) list("FROM Sala s ORDER BY s.numero");
	}
	
	public Sala getSalaByAluno(String matricula) throws DAOException {
		String hql = "SELECT s FROM Aluno a INNER JOIN a.sala s WHERE a.matricula = '" + matricula + "'";
		return (Sala) list(hql).get(0);
	}
}
