<%@ page language="java" pageEncoding="gb2312"%>
<%@ page import="java.util.ArrayList,java.util.Iterator"%>
<%@ page import="common.Format,bean.BookBean"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>

        <title>Search Results</title>
        <%!ArrayList list = null;%>
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

            </table>
        </center>
        <form action=searchBook method=post>
            <table border=0  align=center>
                <tr>
                    <td>
                        <font style="color:darkblue"><strong>Search Book</strong></font>&nbsp;
                    </td>
                    <td>
                        Title:
                        <input type="text" name=bookName style="width:100"/>
                        &nbsp;
                    </td>
                    <td>
                        Author
                        <input type="text" name=author style="width:100"/>
                        &nbsp;
                    </td>
                    <td>
                        Publisher:
                        <input type="text" name=publisher style="width:100"/>
                        &nbsp;
                    </td>
                    <td>
                        Category:
                        <select name=bookType>
                            <option value='' selected>
                                All
                            </option>
                            <option value="computer_science">
                                Computer Science
                            </option>
                            <option value="business">
                                Business
                            </option>
                            <option value="literature">
                                Literature
                            </option>
                            <option value="health">
                                Health
                            </option>
                            <option value="education">
                                Education
                            </option>
                        </select>
                    </td>
                    <td>
                        <input type="submit" value="Search">
                    </td>					
                </tr>
            </table>
        </form>
        <%
            if (session.getAttribute("bookList") != null) {
                list = (ArrayList) session.getAttribute("bookList");
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    BookBean book;
        %>
        <table border=1 width=65%  align=center>
            <caption>
                <font style="font-size:17pt;font-style:italic">Search Results</font>
            </caption>
            <tr align=center>
                <th>
                    Details
                </th>
                <th>
                    Title
                </th>
                <th>
                    Author
                </th>
                <th>
                    Original Price
                </th>
                <th>
                    Discounted
                </th>
                <th width="60">
                    <a href="checkCart">Shopping Cart</a>
                </th>
            </tr>
            <%
                int i = 0;
                while (it.hasNext()) {
                    book = (BookBean) it.next();
                    i++;
            %>
            <tr align=center>
                <td>
                    <form action="SearchBookDetail" method="post">
                        <input type="hidden" name="bookID" value=<%=book.getBookID()%> />
                        <input type="submit" value="Detail">
                    </form>
                </td>
                <td>
                    <%=book.getBookName()%>
                </td>
                <td>
                    <%=book.getAuthor()%>
                </td>
                <td>
                    <strike> <%=Format.numFormat(book.getPrice())%> </strike>
                </td>
                <td>
                    <font><%=Format.numFormat(book.getPriceDiscount())%>
                    </font>
                </td>
                <td>
                    <form action="checkCart" method="post">
                        <input type="hidden" name="bookID" value=<%=book.getBookID()%>  />
                        <input type="hidden" name="bookName"
                               value=<%=book.getBookName()%> />
                        <input type="hidden" name="price" value=<%=book.getPrice()%> />
                        <input type="hidden" name="priceByOff"
                               value=<%=book.getPriceDiscount()%> />
                        <input type="hidden" name="bookView"
                               value=<%=book.getBookView()%> />
                        <input type="image" alt="add to cart" src="./webpic/add_to_cart.jpg" />
                    </form>
                </td>
            </tr>
            <%
                    session.removeAttribute("bookList");
                }
            %>
        </table>
        <%
               } 
                 else {
                    out.println("<center><font color=brown>Sorry, No results found!</font></center>");
                }
            }
               
                 
        %>

        <jsp:include page="bottom.jsp" />
    </body>
</html>
