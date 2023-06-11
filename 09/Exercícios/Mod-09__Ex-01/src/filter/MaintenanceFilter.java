package filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter que checa o arquivo application.properties para verificar se o site est� ou n�o em manuten��o.
 * Esta implementa��o tem fins did�ticos. Numa aplica��o real, ler o arquivo application.properties em todas as requisi��es pode causar
 * perda de performance na aplica��o. O ideal seria ler de tempos em tempos, ou reler o arquivo apenas se alguma modifica��o foi detectada.
 */
public class MaintenanceFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		InputStream is = null;
		Properties props = null;
		
		try {
			//l� o arquivo application.properties, localizado junto com as classes da aplica��o
			is = MaintenanceFilter.class.getResourceAsStream("/application.properties");
			
			//cria o objeto Properties e o popula com base nas propriedades definidas em application.properties
			props = new Properties();
			props.load(is);
		
		} finally {
			if (is != null) {
				//fecha a input stream
				is.close();
			}
		}
		
		//l� a propriedade maintenance
		boolean maintenance = Boolean.valueOf(props.getProperty("maintenance"));
		
		if (!maintenance) {
			//site n�o est� em manuten��o. processar a requisi��o normalmente
			chain.doFilter(request, response);
		} else {
			//site em manuten��o. Direcionar o usu�rio para maintenance.jsp e n�o processar a requisi��o
			request.getRequestDispatcher("maintenance.jsp").forward(request, response);
		}
	}

	
	public void init(FilterConfig config) throws ServletException {
		//nada aqui
	}

	public void destroy() {
		//nada aqui
	}
}
