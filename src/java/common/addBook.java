package common;

import bean.Cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class addBook extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Cart myCart=(Cart)session.getAttribute("myCart");
		String bookID=request.getParameter("bookID");
		
		int bookCount =0;
		try{
			bookCount=Integer.parseInt(request.getParameter("bookCount"));
		}catch(NumberFormatException e){
			bookCount=0;
		}
		bookCount = bookCount <= 0 ? 1 : bookCount;
		
		if(myCart!=null)
			myCart.addBook(bookID, bookCount);
		
		response.sendRedirect("checkCart.jsp");
	}

}
