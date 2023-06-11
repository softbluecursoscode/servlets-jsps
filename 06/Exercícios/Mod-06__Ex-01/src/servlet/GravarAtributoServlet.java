package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet responsável por armazenar no escopo context um atributo com um valor. O atributo e valor são fornecidos via
 * formulário HTTP.
 */
public class GravarAtributoServlet extends HttpServlet {
	
	/*
	 * Como a requisição é POST, o método doPost() é implementado
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//lê os parâmetros vindos da request
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		
		//coloca o atributo no escopo context
		getServletContext().setAttribute(nome, valor);
		
		//faz o redirecionamento para o JSP indicando que o processo terminou com sucesso
		response.sendRedirect("sucesso.jsp");
	}

}
