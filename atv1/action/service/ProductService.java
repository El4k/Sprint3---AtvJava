package br.com.compass.pb.sprint3.atv1.action.service;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.compass.pb.sprint3.atv1.action.Action;
import br.com.compass.pb.sprint3.atv1.dao.ProductDao;
import br.com.compass.pb.sprint3.atv1.dao.UserDao;
import br.com.compass.pb.sprint3.atv1.model.Product;
import br.com.compass.pb.sprint3.atv1.model.User;

public class ProductService implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession sessao = request.getSession();
			User user = (User) sessao.getAttribute("userLogged");
			
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			BigDecimal price = new BigDecimal((request.getParameter("price")));
			
			UserDao userDao = new UserDao();
			
			ProductDao productDao = new ProductDao();
			Product product = new Product(name, description, price);
			productDao.register(product);
			
			if (user.getValueBuy() == null)
				user.setValueBuy(new BigDecimal(0.0));

			user.setValueBuy(user.getValueBuy().add(product.getPrice()));			
			userDao.update(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return "redirect:dashboard?action=UserService";
	}
}