package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.Iterator;
import common.Format;
import bean.BookBean;

public final class bookFullinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=gb2312");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <title>Book Detail Information</title>\r\n");
      out.write("        ");
 BookBean bookresult = null;
      out.write("\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <center>\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "topbar.jsp", out, false);
      out.write("\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.jsp", out, false);
      out.write("\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("        </center>\r\n");
      out.write("        <form action=searchBook method=post>\r\n");
      out.write("            <table border=0  align=center>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <font style=\"color:darkblue\"><strong>Search Book</strong></font>&nbsp;\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        Title:\r\n");
      out.write("                        <input type=\"text\" name=bookName style=\"width:100\"/>\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        Author\r\n");
      out.write("                        <input type=\"text\" name=author style=\"width:100\"/>\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        Publisher:\r\n");
      out.write("                        <input type=\"text\" name=publisher style=\"width:100\"/>\r\n");
      out.write("                        &nbsp;\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        Category:\r\n");
      out.write("                        <select name=bookType>\r\n");
      out.write("                            <option value='' selected>\r\n");
      out.write("                                All\r\n");
      out.write("                            </option>\r\n");
      out.write("                            <option value=\"computer_science\">\r\n");
      out.write("                                Computer Science\r\n");
      out.write("                            </option>\r\n");
      out.write("                            <option value=\"business\">\r\n");
      out.write("                                Business\r\n");
      out.write("                            </option>\r\n");
      out.write("                            <option value=\"literature\">\r\n");
      out.write("                                Literature\r\n");
      out.write("                            </option>\r\n");
      out.write("                            <option value=\"health\">\r\n");
      out.write("                                Health\r\n");
      out.write("                            </option>\r\n");
      out.write("                            <option value=\"education\">\r\n");
      out.write("                                Education\r\n");
      out.write("                            </option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"submit\" value=\"Search\">\r\n");
      out.write("                    </td>\t\t\t\t\t\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");

            if (session.getAttribute("bookinfo") != null) {
                bookresult =(BookBean) session.getAttribute("bookinfo");
        
      out.write("\r\n");
      out.write("        <table border=0 width=65%  align=center>\r\n");
      out.write("            <caption>\r\n");
      out.write("                <font style=\"font-size:17pt;font-style:italic\">Book Detail Information</font>\r\n");
      out.write("            </caption>\r\n");
      out.write("            <tr align=center>\r\n");
      out.write("                ");
      out.print(bookresult.getBookName());
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr align=center>\r\n");
      out.write("                ");
      out.print(bookresult.getAuthor());
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("             <tr align=center>\r\n");
      out.write("                  ");
      out.print(Format.numFormat(bookresult.getPrice()));
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("             <tr align=center>\r\n");
      out.write("                ");
      out.print(Format.numFormat(bookresult.getPriceDiscount()));
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("            \r\n");
      out.write("            ");

                    session.removeAttribute("bookinfo");
                }
            
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("        ");

                
                 else {
                    out.println("<center><font color=brown>Sorry, No results found!</font></center>");
                }
            
               
                 
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "bottom.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
