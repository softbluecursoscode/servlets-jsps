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
 * Filter que checa o arquivo application.properties para verificar se o site está ou não em manutenção.
 * Esta implementação tem fins didáticos. Numa aplicação real, ler o arquivo application.properties em todas as requisições pode causar
 * perda de performance na aplicação. O ideal seria ler de tempos em tempos, ou reler o arquivo apenas se alguma modificação foi detectada.
 */
public class MaintenanceFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		InputStream is = null;
		Properties props = null;
		
		try {
			//lê o arquivo application.properties, localizado junto com as classes da aplicação
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
		
		//lê a propriedade maintenance
		boolean maintenance = Boolean.valueOf(props.getProperty("maintenance"));
		
		if (!maintenance) {
			//site não está em manutenção. processar a requisição normalmente
			chain.doFilter(request, response);
		} else {
			//site em manutenção. Direcionar o usuário para maintenance.jsp e não processar a requisição
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
