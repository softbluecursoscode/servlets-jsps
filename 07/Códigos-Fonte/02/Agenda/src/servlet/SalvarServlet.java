package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agenda;
import model.Contato;

public class SalvarServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = request.getParameter("id") != null ? Integer.valueOf(request.getParameter("id")) : null;
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		
		Contato c = new Contato(id, nome, telefone);
		
		Agenda agenda = Agenda.getInstance();
		agenda.salvar(c);
		
		response.sendRedirect("/Agenda/Listar");
	}
}
