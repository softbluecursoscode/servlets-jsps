package webf.service;

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
	
	public <T extends Service> T getService(Class<T> clazz) throws ServiceException {
		try {
			T service = clazz.newInstance();
			return service;
		} catch (InstantiationException e) {
			throw new ServiceException(e);
		} catch (IllegalAccessException e) {
			throw new ServiceException(e);
		}
	}
}
