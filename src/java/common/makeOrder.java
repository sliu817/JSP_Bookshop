package common;

import db.dbOperation;
import bean.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class makeOrder extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = Convert.codeToString(request.getParameter("username"));
		String usertruename = Convert.codeToString(request.getParameter("usertruename"));
		String address = Convert.codeToString(request.getParameter("address"));
		String telephone = request.getParameter("telephone");
		String postalcode = Convert.codeToString(request.getParameter("postalcode"));

		Cart myCart=null;
		try {
			dbOperation.updateUserInfo(username, usertruename, address,
					telephone, postalcode);
		} catch (Exception e) {
			System.out.println(e);
		}
		int userID = dbOperation.getUserIDByName(username);

		Hashtable buyedBooks = null;
		HttpSession session=request.getSession(true);
		myCart=(Cart)session.getAttribute("myCart");
		if(myCart!=null)
			buyedBooks = myCart.listMyBooks();
		if(buyedBooks!=null)
		if (!buyedBooks.isEmpty() && dbOperation.makeOrder(userID, buyedBooks)) {
			myCart.clear();
			session.removeAttribute("myCart");
			response.sendRedirect("makeOrderSuccessfully.jsp");
		} else {
			response.sendRedirect("makeOrderFailed.jsp");
		}
	}

}
