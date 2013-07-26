<%@ page language="java" import="java.util.*,db.*,bean.*"
	pageEncoding="utf-8"%>

<form action=searchBook method=post>
	<table border=0>
		<tr>
			<td>
				<font style="font-family: georgia; color: darkblue;"><strong>Search Book</strong></font>&nbsp;
			</td>
			<td>
				&nbsp;Title:
				<input type="text" name=bookName style="width:80"/>
			</td>
			<td>
				 &nbsp;Author:
				<input type="text" name=author style="width:80"/>
			</td>
			<td>
                                &nbsp;
				Publisher:
				<input type="text" name=publisher style="width:80"/>
			</td>
                     
			<td>
				&nbsp;Category:
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
				<input type="image" alt="search" src="./webpic/search.jpg"
                                                               name="search">
			</td>
		</tr>
	</table>
</form>
<div align="left">
<table border=0 width=80%>
	<caption>
		<font
			style="font-size:17pt;font-style:italic; height:1px; color:black; padding:1px">Hottest!!!</font>
	</caption>
	<tr>
            <td>
                <form action="SearchBookDetail" method="post">
                        <input type="hidden" name="bookID" value=4 />
                        <input type="image" alt="Not avaible" src="./bookview/php_mysql.jpg" width=100 >
               </form>
            </td>
            <td>
		<table>
                    <tr>
			<td>
                            <font size="2">PHP and MysqlWeb Development</font>
			</td>
                    </tr>
                    <tr>
			<td>
                            <font size="2">Author: Laura Thomson</font>
			</td>
                    </tr>
                    <tr>
			<td> <s>$68.00</s> <font style="color: red">$54.40</font>
			</td>
                    </tr>
		</table>
            </td>
             <td>
                 <form action="SearchBookDetail" method="post">
                        <input type="hidden" name="bookID" value=9 />
                        <input type="image" alt="Not avaible" src="./bookview/javascript.jpg" width=100 >
                 </form>
            </td>
            <td>
		<table>
                    <tr>
			<td>
                            <font size="2">Javascript for Web Developers</font>
			</td>
                    </tr>
                    <tr>
			<td>
                            <font size="2">Author: Nicholas C. Zakas</font>
			</td>
                    </tr>
                    <tr>
			<td> <s>$56.00</s> <font style="color: red">$38</font>
			</td>
                    </tr>
		</table>
            </td>
         </tr>
            
	<tr>
		<td>
                    <form action="SearchBookDetail" method="post">
                        <input type="hidden" name="bookID" value=6 />
                        <input type="image" alt="Not avaible" src="./bookview/marketing.jpg" width=100 >
                 </form>
            </td>
            <td>
		<table>
                    <tr>
			<td>
                            <font size="2">Principles of Marketing</font>
			</td>
                    </tr>
                    <tr>
			<td>
                            <font size="2">Author: Philip Kotler</font>
			</td>
                    </tr>
                    <tr>
			<td> <s>$237.00</s> <font style="color: red">$142.20</font>
			</td>
                    </tr>
		</table>
            </td>
             <td>
                  <form action="SearchBookDetail" method="post">
                        <input type="hidden" name="bookID" value=5 />
                        <input type="image" alt="Not avaible" src="./bookview/microeconomic.jpg" width=100 >
                 </form>
                
            </td>
            <td>
		<table>
                    <tr>
			<td>
                            <font size="2">Principles of Microeconomic</font>
			</td>
                    </tr>
                    <tr>
			<td>
                            <font size="2">Author: John Smith</font>
			</td>
                    </tr>
                    <tr>
			<td> <s>$43.00</s> <font style="color: red">$27.95</font>
			</td>
                    </tr>
		</table>
            </td>
	</tr>
</table>
</div>
