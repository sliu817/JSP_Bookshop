<%@ page language="java" import="java.util.*,bean.*,db.*,java.sql.*"
         pageEncoding="gb2312"%>
<jsp:useBean id="myCart" class="bean.Cart" scope="session"></jsp:useBean>
    <html>
        <head>
            <title>Order Delivery Information</title>
            <script type="text/javascript">
                function checkOrder(){
                    if(order.username.value==""){				
                        alert("Please input your username");
                        return false;
                    }
                    else if(order.usertruename.value==""){
                        alert("Please input your true name");
                        return false;
                    }
                    else if(order.telephone.value==""){				
                        alert("Please input your phone number.");
                        return false;
                    }
                    else if(order.address.value==""){
                        alert("Please input your address.");
                        return false;
                    }
                    else if(order.postalcode.value==""){
                        alert("Please input your post code.");
                        return false;
                    }				
                }
			
            </script>
            <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
        <body>
            <table align=center>
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
                    <%
                        User user = (User) session.getAttribute("user");
                        if (user != null) {
                            String username = user.getUserName();
                            String userTrueName = user.getUserTrueName();
                            String address = user.getAddress();
                            String telephone = user.getTelephone();
                            String postalcode = user.getPostalCode();
                    %>
                    <center>
                        <font size="4" color="blue"><strong>Order Confirmation</strong></font>
                        <br>
                        <p>
                        <form name="order" action="makeOrder" method="post" onSubmit="return checkOrder()">
                            <table>
                                <tr>
                                    <td>
                                        Username:&nbsp;
                                        <input type=text name="username" size=25 value=<%=username%> />
                                    </td>
                                 </tr>
                                 <tr>
                                     <td>
                                        Your True Name:&nbsp;
                                        <input type=text name="usertruename" size=25 value=<%=userTrueName%> />
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>
                                         Phone Number:&nbsp;
                                        <input type=text name="telephone" size=25 value=<%=telephone%> />
                                      </td>
                                 </tr>
                                 <tr>
                                     <td>
                                        Address:&nbsp;
                                        <input type=text name="address" size=25 value=<%=address%> />
                                     </td>
                                 </tr>
                                 <tr>
                                     <td>
                                     Post Code:&nbsp;
                                     <input type=text name="postalcode" size=25 value=<%=postalcode%> />
                                     </td>
                                </tr>
                            </table>
                            <br>
                           
                                <input type="image" alt="place_your_order" src="./webpic/place_your_order.jpg"/>
                               <p>
                                &nbsp;
                                <a href=checkCart.jsp>Check Your Cart</a>&nbsp; &nbsp;
                                <a href=index.jsp>Continue Shopping</a>
                            </p>
                            
                        </form>
                        <p>
                            (Please input the correct delivery information.)
                            <br>
                            <br>
                    </center>
                    <%
                    } else {
                    %>
                    <center>
                        <h3>Cannot get the order. Please log in first.</h3>
                    </center>					
                    <%                                            }
                    %>
                </td>
            </tr>
            <tr>
                <td>
                    <jsp:include page="bottom.jsp" />
                </td>
            </tr>
        </table>
    </body>
</html>
