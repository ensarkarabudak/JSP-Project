package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Database.*;
import java.util.*;
import java.text.DecimalFormat;
import java.sql.*;

public final class arama_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      Database.Connect bean1 = null;
      synchronized (session) {
        bean1 = (Database.Connect) _jspx_page_context.getAttribute("bean1", PageContext.SESSION_SCOPE);
        if (bean1 == null){
          bean1 = new Database.Connect();
          _jspx_page_context.setAttribute("bean1", bean1, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");

String sayfa = (String) request.getParameter("sayfa");
//out.println(sayfa);
boolean devam = false;
if(sayfa.equalsIgnoreCase("deger"))
    devam =true;
if(!devam){

      out.write("\n");
      out.write("    ");
      if (true) {
        _jspx_page_context.forward("index.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("aa", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("aa", request.getCharacterEncoding()));
        return;
      }
      out.write('\n');

}
else 
{           
    String tc=(String)session.getAttribute("kimlikNo");
    String name=(String)session.getAttribute("ad");
    String surname=(String)session.getAttribute("soyad");
    String address=(String)session.getAttribute("adresi");
    String telephone=(String)session.getAttribute("telefonu");
    System.out.println(name+" "+surname);

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>MUSTERI BILGILERI</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <form id=\"form1\" name=\"form1\" style=\"width:300px; height:200px; padding:50px; background-color:activecaption\">\n");
      out.write("    MÜŞTERİ BİLGİLERİ\n");
      out.write("    <br><br>TC NO:<input type=\"text\" name=\"tcNo\" value=\"");
      out.print(tc);
      out.write("\" style=\"margin-left:40px;\">\n");
      out.write("    <br>ADI:<input type=\"text\" name=\"ad\" value=\"");
      out.print(name);
      out.write("\" style=\"margin-left:59px;\">\n");
      out.write("    <br>SOYADI:<input type=\"text\" name=\"soyad\" value=\"");
      out.print(surname);
      out.write("\" style=\"margin-left:27px;\">\n");
      out.write("    <br>ADRES:<input type=\"text\" name=\"adres\" value=\"");
      out.print(address);
      out.write("\" style=\"margin-left:35px;\">\n");
      out.write("    <br>TELEFON:<input type=\"text\" name=\"telefon\" value=\"");
      out.print(telephone);
      out.write("\" style=\"margin-left:17px;\">    \n");
      out.write("    </form>\n");
      out.write("</body>\n");
      out.write("</body>\n");
      out.write("</html>\n");

    }

      out.write('\n');
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
