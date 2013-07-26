package common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import db.dbOperation;

public class acceptUserLogin extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user = (User)session.getAttribute("user");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username==null)username="";
		if(password==null)password="";
		
		if(username!=null && password!=null){
			if(username.equals(user.getUserName())&&password.equals(user.getPassword())){
				response.sendRedirect("bookworm.jsp");
			}
			else if(dbOperation.isUserValidate(username, password)){
				user=new User(username,password);
				session.setAttribute("user", user);
				session.removeAttribute("myCart");
				response.sendRedirect("bookworm.jsp");
			}
			else
				response.sendRedirect("login.jsp");
		}
	}
}
