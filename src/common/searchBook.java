package common;
import db.dbOperation;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.*;

public class searchBook extends HttpServlet{
	ArrayList list=null;
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws
	ServletException,IOException{
		try{
			list=dbOperation.getBooks(
					Convert.codeToString(request.getParameter("bookName")),
					Convert.codeToString(request.getParameter("author")),
					Convert.codeToString(request.getParameter("publisher")),
					Convert.codeToString(request.getParameter("bookType")));
		}catch(SQLException e){
			System.out.println(e);
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("bookList", list);
		response.setContentType("text/html;charset=GB2312");
		response.sendRedirect("searchBookResult.jsp");
		
	}
	
		
	public static void main(String[] args){
		searchBook sb = new searchBook();
		bean.BookBean book = (bean.BookBean)sb.list.get(1);
		System.out.println(book.getBookName());
	}
}
