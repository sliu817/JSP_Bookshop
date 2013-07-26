<%-- 
    Document   : loginFail
    Created on : Dec 4, 2012, 6:29:55 PM
    Author     : ShaLiu
--%>

<%@page contentType="text/html" pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
    <head>
         <meta http-equiv=refresh content="5; url=login.jsp">
        <title>Login Failed</title>
    </head>
    <body>
        <center>
            <table>
                <tr >
                    <td>
                        <jsp:include page="topbar.jsp" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <jsp:include page="top.jsp" />
                    </td>
                </tr>
                <tr>
                    <td align=center>
                        <h2> <img alt="cry" src=".\webpic\cry.gif"/>                  
                            Wrong username and password. 
                        </h2>
                        <h5>
                            <font color="blue">Back to log in in 5 seconds.<a href="register.jsp">Or click here to register!</a>
                            </font>
                        </h5>
                    </td>
                </tr>

                <tr>
                    <td>
                        <jsp:include page="bottom.jsp"></jsp:include>
                    </td>
                </tr>
            </table>



        </center>
    </body>
</html>
