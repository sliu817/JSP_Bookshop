package common;

import bean.Cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class checkCart extends HttpServlet {

	public void destroy() {
		super.destroy();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		Cart myCart = null;


		if (request.getParameter("bookID") != null) {
			String bookID = request.getParameter("bookID");
			
			HttpSession session = request.getSession(true);
			myCart=(Cart)session.getAttribute("myCart");
			if(myCart==null)
				myCart=new Cart();
			myCart.addBook(bookID, 1);
			session.setAttribute("myCart", myCart);
		}
		response.sendRedirect("checkCart.jsp");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.sendRedirect("checkCart.jsp");
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

}
