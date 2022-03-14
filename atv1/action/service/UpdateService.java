package br.com.compass.pb.sprint3.atv1.action.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.compass.pb.sprint3.atv1.action.Action;
import br.com.compass.pb.sprint3.atv1.dao.AddressDao;
import br.com.compass.pb.sprint3.atv1.dao.UserDao;
import br.com.compass.pb.sprint3.atv1.model.Address;
import br.com.compass.pb.sprint3.atv1.model.User;

public class UpdateService implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			UserDao userDao = new UserDao();
			AddressDao addressDao = new AddressDao();
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("userLogged");
			Address address = user.getAddress();
			
			String road = request.getParameter("road");
			Integer numberHouse = Integer.parseInt(request.getParameter("numberHouse"));
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String CEP = request.getParameter("CEP");

			address.setRoad(road);
			address.setNumberHouse(numberHouse);
			address.setCity(city);
			address.setState(state);
			address.setCEP(CEP);
			
			addressDao.update(address);
			userDao.update(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:dashboard?action=UserService";
	}
}