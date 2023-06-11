package security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setId(user);
		userInfo.setSenha(password);
		
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", userInfo);
		
		request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
	}

}
