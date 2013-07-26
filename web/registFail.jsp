<%@ page pageEncoding="GB2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Register Failed</title>
        <meta http-equiv=refresh content="5; url=index.jsp">

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
                            Sorry, this username is already existed. 
                        </h2>
                        <h5>
                            <font color="blue">Back to home in 5 seconds.<a href="index.jsp">Or click here!</a>
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
