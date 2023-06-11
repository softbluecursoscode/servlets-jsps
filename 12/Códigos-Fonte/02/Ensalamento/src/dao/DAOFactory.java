package dao;


public class DAOFactory {

	private static DAOFactory instance;
	
	private DAOFactory() {
	}
	
	public static DAOFactory getInstance() {
		if (instance == null) {
			instance = new DAOFactory();
		}
		return instance;
	}
	
	public AlunoDAO getAlunoDAO() {
		AlunoDAO dao = new AlunoDAO();
		return dao;
	}
	
	public SalaDAO getSalaDAO() {
		SalaDAO dao = new SalaDAO();
		return dao;
	}
}
