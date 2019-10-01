package br.ucsal.busucsal.fiter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/LogFilter")
public class LogFilter implements Filter {

    public LogFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long tempoInicio = System.currentTimeMillis();
		System.out.println("Entrou na pagina: "+request.getRemoteAddr());
		chain.doFilter(request, response);
		System.out.println("Saiu da pagina: "+request.getRemoteAddr());	
		System.out.println("Tempo Total de carregamento: "+(System.currentTimeMillis()-tempoInicio));
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
