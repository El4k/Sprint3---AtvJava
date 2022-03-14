package br.com.compass.pb.sprint3.atv1.action.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.compass.pb.sprint3.atv1.action.Action;
import br.com.compass.pb.sprint3.atv1.dao.UserDao;
import br.com.compass.pb.sprint3.atv1.model.User;

public class RemoveService implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			UserDao usuarioDao = new UserDao();
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("userLogged");
			usuarioDao.remove(user);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:dashboard?action=LoginController";
	}
}