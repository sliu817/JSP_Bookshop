<%@ page language="java" pageEncoding="gb2312"%>

<html>
    <head>
        <title>Online Bookstore</title>
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
                    <td>
                        <jsp:include page="show.jsp"/>
                    </td>  	
                </tr>
                <tr>
                    <td>
                        <jsp:include page="bottom.jsp"/>
                    </td>
                </tr>
            </table>  
        </center>
    </body>
</html>
