package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class ControllerServlet extends HttpServlet {
	
	private static Properties actions;
	
	static {
		try {
			InputStream is = ControllerServlet.class.getResourceAsStream("/action.properties");
			actions = new Properties();
			actions.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String path = request.getServletPath();
		path = path.substring(1, path.indexOf("."));
		
		String actionClass = actions.getProperty(path);
		
		if(actionClass == null) {
			throw new ServletException("A action '" + path + "' não está mapeada");
		}
			
		try {
			Action action = (Action) Class.forName(actionClass).newInstance();
			action.setRequest(request);
			action.setResponse(response);
			action.runAction();
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
