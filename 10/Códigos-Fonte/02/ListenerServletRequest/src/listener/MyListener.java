package listener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;


public class MyListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent e) {
		System.out.println("Request destruída!");
	}

	@Override
	public void requestInitialized(ServletRequestEvent e) {
		ServletRequest request = e.getServletRequest();
		request.setAttribute("user", "1234");
		System.out.println("Request inicializada!");
	}

	
}
