package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class AutoInit1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String adminEmail;

	public void init(ServletConfig config) throws ServletException {
		
		String email = config.getInitParameter("adminEmail");
		this.adminEmail = email;
		
		System.out.println("Servlet carregado! adminEmail = " + email);
	}

	public String getAdminEmail() {
		return adminEmail;
	}
}
