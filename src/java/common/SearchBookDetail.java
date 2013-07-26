/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;
import bean.BookBean;
import db.dbOperation;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SearchBookDetail extends HttpServlet{
        BookBean bookresult = null;
    
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws
	ServletException,IOException{
		try{
			bookresult =dbOperation.getBookInfo(
					request.getParameter("bookID"));
		}catch(SQLException e){
			System.out.println(e);
                        response.sendRedirect("index.jsp");
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("bookinfo", bookresult);
		response.setContentType("text/html;charset=GB2312");
		response.sendRedirect("bookFullinfo.jsp");
               
		
	}

}
