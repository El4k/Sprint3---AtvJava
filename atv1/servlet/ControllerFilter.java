package br.com.compass.pb.sprint3.atv1.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compass.pb.sprint3.atv1.action.Action;

public class ControllerFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAction = request.getParameter("action");
		String nameClass = "br.com.compass.pb.sprint3.atv1.action.controller." + paramAction;
		String nameSecondClass = "br.com.compass.pb.sprint3.atv1.action.service." + paramAction;
		String name;
		
		try {
			Class firstClass = Class.forName(nameClass);
			Action action = (Action) firstClass.newInstance();
			name = action.execute(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
			try {
				Class secondClass = Class.forName(nameSecondClass);
				Action actionSecond = (Action) secondClass.newInstance();
				name = actionSecond.execute(request, response);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException| IOException e2) {
				throw new ServletException(e2);
			}
		}	
		
		String[] typeAdress = name.split(":");
		if (typeAdress[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("view/" + typeAdress[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(typeAdress[1]);
		}
	}

	@Override
	public void destroy() {
	}
}