<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>

<html>
    <head>
        <title>Order failed!</title>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
                        Dear customers. We are sorry that the order you placed did not process successfully. Please try it again later.<br/>
                        If you have any questions, feel free to contact us. Thank You!
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
