package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HTMLServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		PrintWriter out = null;
//		
//		try {
//			out = response.getWriter();
//			
//			response.setContentType("text/html");
//			
//			out.print("<HTML>");
//			out.print("<HEAD>");
//			out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
//			out.print("</HEAD>");
//			out.print("<BODY>");
//			out.print("<H1>Título da Página</H1>");
//			out.print("<STRONG>Este é um texto em negrito</STRONG>");
//			out.print("</BODY></HTML>");
//			
//		} finally {
//			if (out != null) {
//				out.close();
//			}
//		}
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fis = new FileInputStream("D:/Temp/JavaWeb/arquivo.zip");
		byte[] buffer = new byte[1024];
		int b;
		
		while ((b = fis.read(buffer)) > -1) {
			out.write(buffer, 0, b);
		}
		out.close();
		fis.close();
	}
}
