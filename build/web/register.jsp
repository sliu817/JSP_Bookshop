<%@ page language="java" pageEncoding="gb2312"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
        <title>Sign up</title>

        <script language="javascript">
            function on_submit(){//验证数据合法性
                if(form1.username.value == ""){
                    alert("username cannot be empty.");
                    form1.username.focus();
                    return false;
                }
                if(form1.password.value == ""){
                    alert("Password cannot be empty.");
                    form1.password.focus();
                    return false;
                }
                var txt = document.forms[0].password.value;
                if(txt.search("^[A-Za-z0-9]+$") !=0){
                    document.forms[0].password.select();
                    alert("Password should be letters, digits or their combinations.");
                    return false;			
                }
                if(form1.checkpassword.value == ""){
                    alert("confirm password should not be empty.");
                    form1.checkpassword.focus();
                    return false;
                }
                if(form1.password.value != form1.checkpassword.value){
                    alert("Passwords are not consistent.");
                    form1.checkpassword.focus();
                    return false;
                }
                if(form1.telephone.value != null && form1.telephone.value != ""){
                    var txt = document.forms[0].telephone.value;
                    if(txt.search("^\\d+(\\.\\d+)*$") != 0){			
                        document.forms[0].telephone.select();
                        alert("Phone number should be digits.");
                        return false;
                    }
                }
		
            }	
        </script>

    </head>

    <body>
        <center>

            <form id="form1" name="form1" method="post" action="acceptUserRegist" onsubmit="return on_submit()">
                <table border=0>
                   
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
                                            <strong>Sign up here!</strong><br><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Username:<input type="text" name="username" />*</td>
                                    </tr>
                      
                                    <tr>
                                        <td>Password:<input type="password" name="password" />*</td>
                                    </tr>
                                    <tr>
                                        <td>Confirm Password: <input type="password" name="checkpassword" />*</td>
                                    </tr>
                                    <tr>
                                        <td>True Name:<input type="text" name="userTruename" /></td>
                            
                                    </tr>
                                    <tr>
                                        <td>Phone Number:<input type="text" name="telephone" /></td>
                                    </tr>
                                     <tr>
                                        <td>Address: <input type="text" name="address" /></td> 
                                    </tr>
                                    <tr>
                                        <td>Post Code:<input type="text" name="postalcode" /></td>                           
                                     </tr>
                                     <tr>
                                        <td colspan="2" align="center">
                                            <input type="submit" name="submit" value="submit"/>
                                            &nbsp;&nbsp;&nbsp;
                                            <input type="reset" value="reset"/>
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
