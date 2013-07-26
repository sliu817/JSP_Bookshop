<%@ page language="java" pageEncoding="gb2312"%>
<html>
    <body>
        <center>
            <form action="acceptUserLogin" method="post">
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
                            <div align=center>
                                <table>
                                    <tr>
                                        <td>
                                            <strong>You haven't logged in. Please log in.<br><br>
                                        </td>
                                    </tr>
                                    <tr>
                                         <td>
                                              Username:
                                              <input type="text" name="username">
                                          </td>
                                    </tr>
                                    <tr>
                                          <td>
                                              Password:
                                              <input type="password" name="password">
                                              <br>
                                          </td>
                                     </tr>
                                                <tr>
                                                    <td align=center>
                                                        <input type="image" alt="login" src="./webpic/login-gold-3d.gif"
                                                               name="login">
                                                    </td>
                                                </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <jsp:include page="bottom.jsp" />
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>
