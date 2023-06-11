package service;

import dao.AlunoDAO;
import dao.DAOException;
import dao.SalaDAO;
import entity.Aluno;
import entity.Sala;

public class EnsalamentoService extends Service {

	public void removerAlunoSala(String matricula) throws ServiceException {
		try {
			AlunoDAO alunoDAO = daoFactory.getAlunoDAO();
			Aluno aluno = alunoDAO.load(matricula);
			aluno.setSala(null);
		
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public void adicionarAlunoSala(String matricula, int numSala) throws ServiceException {
		try {
			AlunoDAO alunoDAO = daoFactory.getAlunoDAO();
			Aluno aluno = alunoDAO.load(matricula);
			
			SalaDAO salaDAO = daoFactory.getSalaDAO();
			Sala sala = salaDAO.load(numSala);
			
			aluno.setSala(sala);
		
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public Sala getSalaByAluno(String matricula) throws ServiceException {
		try {
			SalaDAO salaDAO = daoFactory.getSalaDAO();
			return salaDAO.getSalaByAluno(matricula);
		
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
