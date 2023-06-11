package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet que lista os atributos presentes no escopo context
 */
public class ListarAtributosServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//retorna a lista com o nome dos atributos presentes no escopo context
		Enumeration<String> atributos = getServletContext().getAttributeNames();
		
		//map para armazenar os atributos que serão passados ao JSP. O TreeMap garante a ordenação alfabética por nome
		Map<String, Object> map = new TreeMap<String, Object>();
		
		//itera sobre os atributos encontrados
		while (atributos.hasMoreElements()) {
			String name = atributos.nextElement();
			
			//obtém o valor do atributo
			Object value = getServletContext().getAttribute(name);
			
			//adiciona o atributo no map
			map.put(name, value);
		}
		
		//coloca o map na request para que ele seja lido para o JSP
		request.setAttribute("atributos", map);
		
		//direciona para o JSP que vai fazer a listagem
		request.getRequestDispatcher("listar.jsp").forward(request, response);
	}

}
