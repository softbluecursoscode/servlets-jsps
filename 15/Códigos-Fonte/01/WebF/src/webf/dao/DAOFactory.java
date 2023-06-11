package webf.dao;



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
	
	public <T extends DAO<?>> T getDAO(Class<T> clazz) throws DAOException {
		try {
			T dao = clazz.newInstance();
			return dao;
		} catch (InstantiationException e) {
			throw new DAOException(e);
		} catch (IllegalAccessException e) {
			throw new DAOException(e);
		}
	}
}
