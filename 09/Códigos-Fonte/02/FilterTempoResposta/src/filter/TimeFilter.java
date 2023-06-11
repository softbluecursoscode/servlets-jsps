package filter;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TimeFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		long inicio = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long fim = System.currentTimeMillis();
		
		long time = fim - inicio;
		
		FileWriter fw = new FileWriter("d:/temp/JavaWeb/time.txt", true);
		fw.write("URI: " + req.getRequestURI() + ": " + time + "ms");
		fw.write(System.getProperty("line.separator"));
		fw.close();
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}
}
