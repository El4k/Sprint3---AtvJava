package br.com.compass.pb.sprint3.atv1.action.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compass.pb.sprint3.atv1.action.Action;
import br.com.compass.pb.sprint3.atv1.dao.AddressDao;
import br.com.compass.pb.sprint3.atv1.dao.UserDao;
import br.com.compass.pb.sprint3.atv1.model.Address;
import br.com.compass.pb.sprint3.atv1.model.User;

public class RegistreService implements Action {
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDao userDao = new UserDao();
			AddressDao addressDao = new AddressDao();
			
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String road = request.getParameter("road");
			Integer numberHouse = Integer.parseInt(request.getParameter("numberHouse"));
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String CEP = request.getParameter("CEP");
			
			Address address = new Address(road, numberHouse, city, state, CEP);
			addressDao.register(address);
			
			User user = new User(login, password, address);
			userDao.register(user);
			
			return "redirect:dashboard?action=LoginController";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
