package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Servlet que salva os dados digitados na session
 */
public class CadastrarServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obtém a referência à session
		HttpSession session = request.getSession();
		
		//obtém a página atual. Este parâmetro é passado através de um campo hidden no formulário
		int pagina = Integer.parseInt(request.getParameter("pagina"));
		String proximaPagina = null;
		
		//checa de qual página o usuário veio e, dependendo da página, pega os parâmetros da request correspondentes
		if (pagina == 1) {
			String email = request.getParameter("email");
			session.setAttribute("email", email);
			proximaPagina = "/tela2.jsp";
		
		} else if (pagina == 2) {
			String nome = request.getParameter("nome");
			session.setAttribute("nome", nome);
			proximaPagina = "/tela3.jsp";
		
		} else if (pagina == 3) {
			String telefone = request.getParameter("telefone");
			session.setAttribute("telefone", telefone);
			proximaPagina = "/dados.jsp";
		}
		
		//direciona para a próxima tela 
		request.getRequestDispatcher(proximaPagina).forward(request, response);
	}
}
