package common;

import db.dbOperation;
import common.Convert;
import bean.User;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class acceptUserRegist extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=Convert.codeToString(request.getParameter("username"));
		String password=Convert.codeToString(request.getParameter("password"));
		String userTruename=Convert.codeToString(request.getParameter("userTruename"));
		String address=Convert.codeToString(request.getParameter("address"));
		String telephone=Convert.codeToString(request.getParameter("telephone"));
		String postalCode=Convert.codeToString(request.getParameter("postalcode"));
		
		User user=new User(username, password, userTruename, address, telephone, postalCode);
		
		boolean isSuccessful=dbOperation.registerUserSuccess(user);
		if(isSuccessful){			
			HttpSession session=request.getSession(true);
			session.removeAttribute("user");
			session.setAttribute("user", user);
			response.sendRedirect("registSuccessful.jsp");
		}else{
			response.sendRedirect("registFail.jsp");
		}
	}
}
