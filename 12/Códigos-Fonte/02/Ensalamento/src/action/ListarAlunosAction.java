package action;

import java.util.List;

import dao.AlunoDAO;

import service.SalaService;
import entity.Aluno;
import entity.Sala;

public class ListarAlunosAction extends Action {

	@Override
	public void process() throws Exception {
		
		int numSala = Integer.parseInt(getRequest().getParameter("numSala"));
		String ordemStr = getRequest().getParameter("ordem");
		AlunoDAO.Ordem ordem = ordemStr == null ? AlunoDAO.Ordem.MATRICULA : AlunoDAO.Ordem.valueOf(ordemStr);
		
		SalaService salaService = serviceFactory.getSalaService();
		List<Aluno> alunos = salaService.getAlunosBySala(numSala, ordem);
		
		Sala sala = salaService.loadSala(numSala);
		
		getRequest().setAttribute("alunos", alunos);
		getRequest().setAttribute("numAlunos", alunos.size());
		getRequest().setAttribute("sala", sala);
		forward("lista_alunos.jsp");
	}
}
