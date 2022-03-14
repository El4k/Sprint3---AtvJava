
package br.com.compass.pb.sprint3.atv1.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MonitoringFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long before = System.currentTimeMillis();

		String action = request.getParameter("action");

		chain.doFilter(request, response);
		long after = System.currentTimeMillis();

		System.out.println("Execution Time of: " + action + ": " + (after - before));
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException { 
	}

	@Override
	public void destroy() { 
	}
}
