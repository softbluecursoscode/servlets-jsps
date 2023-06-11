package service;

public class ServiceFactory {

	private static ServiceFactory instance;
	
	private ServiceFactory() {
	}
	
	public static ServiceFactory getInstance() {
		if (instance == null) {
			instance = new ServiceFactory();
		}
		return instance;
	}
	
	public SalaService getSalaService() {
		SalaService service = new SalaService();
		return service;
	}
	
	public AlunoService getAlunoService() {
		AlunoService service = new AlunoService();
		return service;
	}
	
	public EnsalamentoService getEnsalamentoService() {
		EnsalamentoService service = new EnsalamentoService();
		return service;
	}
}
