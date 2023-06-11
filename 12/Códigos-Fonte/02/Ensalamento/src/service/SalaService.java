package service;

import java.util.List;

import dao.AlunoDAO;
import dao.DAOException;
import dao.SalaDAO;
import entity.Aluno;
import entity.Sala;

public class SalaService extends Service {

	public List<Sala> getSalas() throws ServiceException {
		try {
			SalaDAO salaDAO = daoFactory.getSalaDAO();
			List<Sala> salas = salaDAO.getSalas();
			return salas;

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public List<Aluno> getAlunosBySala(int numSala, AlunoDAO.Ordem ordem)
			throws ServiceException {
		try {
			AlunoDAO alunoDAO = daoFactory.getAlunoDAO();
			List<Aluno> alunos = alunoDAO.getAlunosBySala(numSala, ordem);
			return alunos;

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public Sala loadSala(int numSala) throws ServiceException {
		try {
			SalaDAO salaDAO = daoFactory.getSalaDAO();
			Sala sala = salaDAO.load(numSala);
			return sala;

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
