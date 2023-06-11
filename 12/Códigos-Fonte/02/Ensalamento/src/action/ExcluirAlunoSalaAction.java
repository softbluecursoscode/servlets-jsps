package action;

import entity.Sala;
import service.EnsalamentoService;

public class ExcluirAlunoSalaAction extends Action {

	@Override
	public void process() throws Exception {
		
		String matricula = getRequest().getParameter("matricula");
		
		EnsalamentoService ensalamentoService = serviceFactory.getEnsalamentoService();
		Sala sala = ensalamentoService.getSalaByAluno(matricula);
		
		ensalamentoService.removerAlunoSala(matricula);
		
		redirect("ListarAlunos.action?numSala=" + sala.getNumero());
	}
}
