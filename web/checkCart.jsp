<%@ page language="java" import="java.util.*,java.sql.*,db.*,bean.*"
         pageEncoding="gb2312"%>
<jsp:directive.page import="common.Format;" />

<html>
    <head>
        <title>Shopping Cart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    </head>

    <body>
        <center>
        <table>
            <tr>
                <td>
                    <jsp:include page="topbar.jsp"/>
                </td>
            </tr>
            <tr>
                <td>
                    <jsp:include page="top.jsp" />
                </td>
            </tr>
        </table>

        <br>
        <font size="4" color="brown">Check Shopping Cart</font>&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="index.jsp">Continue Shopping</a>

        <br>
        <%
            Hashtable buyedBooks = null;
            double totalPrice = 0;//Total original price
            double totalPriceDiscount = 0;//Total price after discount
            int bookCount = 0;

            try {
        %>
        <p>
        <center>
            <table  cellSpacing=0 cellPadding=10 width="65%" border=0>
                <tr bgColor=#d7ebff>
                    <td colSpan=2 width=300>
                        <strong>Items in Cart:</strong>
                    </td>
                    <td width=100>
                        <strong>Original Price</strong>
                    </td>
                    <td width=100>
                        <strong>Discounted</strong>
                    </td>
                    <td width=70>
                         <strong>Quantity</strong>
                    </td>
                </tr>
                <%
                    Cart myCart = (Cart) session.getAttribute("myCart");
                    if (myCart == null) {
                        myCart = new Cart();
                    }
                    buyedBooks = myCart.listMyBooks();
                    Enumeration enume = buyedBooks.keys();
                    while (enume.hasMoreElements()) {
                        String bookKey = (String) enume.nextElement();
                        byte[] b = bookKey.getBytes("ISO-8859-1");
                        bookKey = new String(b);
                        BookBean book = dbOperation.getBookInfo(bookKey);

                       
                        String bookName = book.getBookName();
                        double price = book.getPrice();
                        double priceDiscount = book.getPriceDiscount();
         
                        bookCount = ((Integer) buyedBooks.get(bookKey)).intValue();
                        totalPrice += price * bookCount;
                        totalPriceDiscount += priceDiscount * bookCount;
                %>
                <tr>
                    <td colSpan=2>
                        <form id="listBook" action="removeBook" method="post">
                            <input type="hidden" name="bookID" value="<%=bookKey%>"/>
                           <input type="image" alt="delete" src="./webpic/delete.gif" border="0"
								name="image1"/>
                            &nbsp;
                            <%=bookName%>
                        </form>

                    </td>
                    <td align=center>
                        <s><%=Format.numFormat(price)%> </s>
                    </td>
                    <td align=center>
                        <%=Format.numFormat(priceDiscount)%>
                    <td align=center>
                        <form id="updateBookCount" action="addBook" method="post">
                            <input type="text" size=3  maxlength=3
                                   name="bookCount" value="<%=bookCount%>">
                            <input type="hidden" name="bookID" value="<%=bookKey%>" >
                            <input type="image" alt="update_quantity" src="./webpic/update-t-sm.gif"
								border="0" name="image2"/>
                        </form>
                    </td>
                </tr>

                <%
                    }
                %>
            </table>
            <hr width="65%" size=2>

            <table cellSpacing=0 cellPadding=10 width="55%" border=0>
                <tr>
                    <td colSpan=2 width=300>
                        <div align=right>
                            <strong>Total:</strong></div> 
                    </td>
                    <td width=100>
                        <div align=center>
                            <font color=black><%=Format.numFormat(totalPrice)%>							</strong></s>
                        </div>    


                    </td>
                    <td width=100>
                        <div align=center>
                            <font color=brown><%=Format.numFormat(totalPriceDiscount)%></div> 

                    </td>
                    <td width=70>
                        <div align=center>
                            <strong></strong></div>
                    </td>
                </tr>
            </table>

            <table width="65%">
                <tr>
                    <td width=300>

                    </td>
                    <td align=center>
                        <form action="orderForm" method="post">
                            <input type="image" alt="checkout" src="./webpic/by-split.gif"
                                   name="image1">
                        </form>
                    </td>
                </tr>
            </table>
            <%
                } catch (Exception e) {
                    out.print(e);
                }
            %>
            <br>
            <br>
            <div>
                <table cellSpacing=0 cellPadding=10 width="66%" border=0>
                    <tr valign="top" bgcolor="EEEECC">
                        <td colspan="5" class="font14">
                            <strong>&nbsp;Note:</strong>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td colspan="5">
                            <ul>
                                <li>
                                    You can input the quantity as you need.
                                </li>
                                <li>
                                    Please place your order after log in.
                                </li>
                            </ul>
                        </td>
                    </tr>
                </table>
            </div>
            <jsp:include page="bottom.jsp" />
            </center>
    </body>
</html>
