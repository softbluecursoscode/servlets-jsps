package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet respons�vel por armazenar no escopo context um atributo com um valor. O atributo e valor s�o fornecidos via
 * formul�rio HTTP.
 */
public class GravarAtributoServlet extends HttpServlet {
	
	/*
	 * Como a requisi��o � POST, o m�todo doPost() � implementado
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//l� os par�metros vindos da request
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		
		//coloca o atributo no escopo context
		getServletContext().setAttribute(nome, valor);
		
		//faz o redirecionamento para o JSP indicando que o processo terminou com sucesso
		response.sendRedirect("sucesso.jsp");
	}

}
