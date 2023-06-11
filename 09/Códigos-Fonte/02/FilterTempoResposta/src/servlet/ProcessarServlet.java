package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
			}
			
			out.print("Processamento realizado!");

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
