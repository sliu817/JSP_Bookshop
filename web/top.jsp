<%@ page pageEncoding="gb2312"%>
<%@ page import="bean.User" %>
<%! User user = null;%>
<a href="index.jsp" ><img src="./webpic/bookworm.png" height="55"/></a>
<a href="index.jsp" style="text-decoration:none"><font size="4" color="#BE9D2E" style="font-family: Arial;" >Home</font></a>	

&nbsp;&nbsp;&nbsp;
<a href="checkCart" style="text-decoration:none"><img src="./webpic/cart.gif"  border="0" name="cart" ><font size="4" color="#BE9D2E" style="font-family: Arial;">Cart</font></a>
<div align="right">
    <table>	
        <tr>
            <td align=left>
                <% user = (User) session.getAttribute("user");
                    if (user != null) {
                        out.print("Hello," + user.getUserName() + "!&nbsp&nbsp<a href=Logout>Logout</a>&nbsp&nbsp");
                    }
                %>
            </td>
            <td>
                <a href="login.jsp"><img src="./webpic/login-gold-3d.gif" border="0" name="login"></a>
                <a href="register.jsp"><img src="./webpic/newuser-gold-3d.gif" border="0"></a>				
            </td>	
        </tr>	
    </table>
</div>