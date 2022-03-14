package br.com.compass.pb.sprint3.atv1.action.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.compass.pb.sprint3.atv1.action.Action;
import br.com.compass.pb.sprint3.atv1.dao.UserDao;
import br.com.compass.pb.sprint3.atv1.model.User;

public class LoginService implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		boolean condition = false;
		
		try {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			
			UserDao userDao = new UserDao();
			User user = userDao.searchUser(login, password);
			condition = false;
			session.setAttribute("userLogged", user);
			return "redirect:dashboard?action=UserService";
		} catch (Exception e) {
			condition = true;
			return "redirect:dashboard?action=LoginController";
		} finally {
			session.setAttribute("condition", condition);
		}
	}
}
