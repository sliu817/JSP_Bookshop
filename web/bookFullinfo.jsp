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

        <title>Book Detail Information</title>
        <% BookBean book = null;%>
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
            if (session.getAttribute("bookinfo") != null) {
                book =(BookBean) session.getAttribute("bookinfo");
        %>
        <table border=0 width=50%  align=center>
        
            <tr>
                <td rowspan="8" >
                 <img src=" <%=book.getBookView()%>" alt="Not avaible" />  
                </td>  
                <td>
                   <font style="size:8; color:darkblue; font-family: Arial;"> <strong>&nbsp;&nbsp;<%=book.getBookName()%> </strong></font>
                </td>
            </tr>
            
            <tr>
                 <td>
                   &nbsp;&nbsp; Author: <%=book.getAuthor()%>
                </td> 
            </tr>
            <tr>
                 <td>
                    &nbsp;&nbsp;Publisher:<%=book.getPublisher()%>
                </td> 
            </tr>
            <tr>
                 <td>
                    &nbsp;&nbsp;List Price: <%=Format.numFormat(book.getPrice())%>
                </td> 
            </tr>
            <tr>
                 <td>
                    &nbsp;&nbsp;Price: <font style="color:red"> <%=Format.numFormat(book.getPriceDiscount())%></font>
                </td> 
            </tr>
            
            <tr>
                <td> 
                    <br/>
                <font style="size:8; color:darkblue; font-family: Arial;">&nbsp;&nbsp;Book Description</font>          
                </td>
             </tr>
             <tr>
                 
               <td colspan="3">
                     &nbsp;   &nbsp;   &nbsp;&nbsp; <%=book.getSimpleContent()%>
               </td>
            </tr>
            <tr>
                 <td>
                     <br/>
                    <form action="checkCart" method="post">
                        <input type="hidden" name="bookID" value=<%=book.getBookID()%>  />
                        <input type="hidden" name="bookName"
                               value=<%=book.getBookName()%> />
                        <input type="hidden" name="price" value=<%=book.getPrice()%> />
                        <input type="hidden" name="priceByOff"
                               value=<%=book.getPriceDiscount()%>  />
                        <input type="hidden" name="bookView"
                               value=<%=book.getBookView()%>  />
                        &nbsp;   &nbsp;   &nbsp;&nbsp;
                        <input type="image" alt="add to cart" src="./webpic/add_to_cart.jpg" />
                    </form>
                </td>
             </tr>
               
            
            <%
                    session.removeAttribute("bookinfo");
                }
            %>
        </table>
   
        <jsp:include page="bottom.jsp" />
    </body>
</html>
