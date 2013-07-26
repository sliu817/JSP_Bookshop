package common;

import bean.User;
import db.dbOperation;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class acceptUserLogin extends HttpServlet {

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                HttpSession session = request.getSession(true);
		//User user = (User)session.getAttribute("user");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username==null) {
                                username="";
                            }
		if(password==null) {
                                password="";
                            }
		
		if(username!=null && password!=null){
			//if(username.equals(user.getUserName())&&password.equals(user.getPassword())){
				//response.sendRedirect("index.jsp");
			//}
			//else
                    if(dbOperation.isUserValidate(username, password)){
				User user=new User(username,password);
				session.setAttribute("user", user);
				session.removeAttribute("myCart");
				response.sendRedirect("index.jsp");
			}
			else
                        {
				response.sendRedirect("loginFail.jsp");
                        }
		}
	}
    
}
