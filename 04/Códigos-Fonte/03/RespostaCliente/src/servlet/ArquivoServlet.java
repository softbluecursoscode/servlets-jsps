package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArquivoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OutputStream out = null;
		FileInputStream fis = null;
		
		try {
			out = response.getOutputStream();
			
			response.addHeader("Content-Disposition", "attachment; filename=arquivo.zip");
		
			response.setContentType("application/zip");
			
			fis = new FileInputStream("D:/Temp/JavaWeb/arquivo.zip");
			
			byte[] buffer = new byte[1024];
			int b;
			
			while ((b = fis.read(buffer)) > -1) {
				out.write(buffer, 0, b);
			}
		
		} finally {
			if (fis != null) { 
				fis.close();
			}
			if (out != null) { 
				out.close();
			}
		}
	}
}
