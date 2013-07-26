<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<jsp:directive.page import="bean.User;"/>

<%!    String username = "Dear customer";
    User user = null;
%>
<%
    user = (User) session.getAttribute("user");
    if (user != null) {
        username = user.getUserName();
    }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>    
        <title>Register Successfully</title>
        <meta http-equiv=refresh content="5; url=index.jsp">
    </head>

    <body>
        <center>  
            <jsp:include flush="true" page="topbar.jsp"></jsp:include>  	
            <jsp:include flush="true" page="top.jsp"></jsp:include>

                <h2><img alt="Hi" src=".\webpic\hi.gif"/>Hi, <%=username%> Sign up successfully!</h2>
            <h5><font color="blue">Back to home in 5 seconds.<a href="index.jsp">Or click here!</a></font></h5>
            <jsp:include flush="true" page="bottom.jsp"></jsp:include>
        </center>
    </body>
</html>
