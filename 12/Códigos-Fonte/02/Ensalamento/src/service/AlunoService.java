package service;

import java.util.List;

import dao.AlunoDAO;
import dao.DAOException;

import entity.Aluno;

public class AlunoService extends Service {

	public List<Aluno> getAlunosByNome(String nome) throws ServiceException {
		try {
			AlunoDAO alunoDAO = daoFactory.getAlunoDAO();
			List<Aluno> alunos = alunoDAO.getAlunosNaoEnsaladosByNome(nome);
			return alunos;

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
