package br.com.compass.pb.sprint3.atv1.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutorizationFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAction = request.getParameter("action");
		HttpSession session = request.getSession();

		boolean userOff = (session.getAttribute("userLogged") == null);
		boolean actionProtected = 
				!( paramAction.equals("ErrorController") 	|| paramAction.equals("LogoutService")
				|| paramAction.equals("LoginController") 	|| paramAction.equals("LoginService")
				|| paramAction.equals("RegistreController") || paramAction.equals("RegistreService")
				|| paramAction.equals("ProductController") 	|| paramAction.equals("ProductService")
				|| paramAction.equals("UpdateController") 	|| paramAction.equals("UpdateService")
				|| paramAction.equals("MailController") 	|| paramAction.equals("MailService")
				|| paramAction.equals("FeeController")		|| paramAction.equals("UserService"));
		if (userOff && actionProtected) {
			response.sendRedirect("dashboard?action=ErrorController");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}