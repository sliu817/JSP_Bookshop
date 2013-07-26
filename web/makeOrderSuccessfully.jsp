<%@ page language="java" import="java.util.*,bean.*,db.*"
         pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Order Successfully</title>
    </head>

    <body>
        <center>
            <table>
                <tr>
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
                        Dear Customers, your order has been <strong> placed successfully.</strong><br/>
                   
                        Thank you for shopping with us!
          
                        <br>
                        <a href=index.jsp>Back to Home</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <br>
                        <br>
                        <jsp:include page="bottom.jsp" />
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>
