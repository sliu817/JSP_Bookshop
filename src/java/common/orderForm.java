package common;

import bean.Cart;
import bean.User;
import db.dbOperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class orderForm extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		Cart myCart = (Cart) session.getAttribute("myCart");
		if (myCart != null && !myCart.listMyBooks().isEmpty())
			if (user != null) {
				String username = user.getUserName();
				user = dbOperation.getUser(username);

				session.setAttribute("user", user);
				response.sendRedirect("orderForm.jsp");
			} else
				response.sendRedirect("login.jsp");
		else
			response.sendRedirect("index.jsp");
	}
}
