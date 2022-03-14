package br.com.compass.pb.sprint3.atv1.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.compass.pb.sprint3.atv1.model.User;
import br.com.compass.pb.sprint3.atv1.util.JPAUtil;

@WebServlet("/mail")
public class MailService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userLogged");
		User printed = new User();
		printed.setValueFee(user.getValueFee());
		printed.setDeadline(user.getDeadline());

		Gson gson = new Gson();
		String json = gson.toJson(printed);
		
		response.getWriter().print(json);
		em.close();
	}
}