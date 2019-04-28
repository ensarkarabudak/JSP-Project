<jsp:useBean id="bean1" class="Database.Connect" scope="session" />
<%@page import="Database.*, java.util.*, java.text.DecimalFormat, java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String sayfa = (String) request.getParameter("sayfa");
//out.println(sayfa);
boolean devam = false;
if(sayfa.equalsIgnoreCase("deger"))
    devam =true;
if(!devam){
%>
    <jsp:forward page="index.jsp">
        <jsp:param name="aa" value="aa"/>
    </jsp:forward>
<%
}
else 
{           
    String tc=(String)session.getAttribute("kimlikNo");
    String name=(String)session.getAttribute("ad");
    String surname=(String)session.getAttribute("soyad");
    String address=(String)session.getAttribute("adresi");
    String telephone=(String)session.getAttribute("telefonu");
    System.out.println(name+" "+surname);
%>

<html>
<head>
    <title>MUSTERI BILGILERI</title>
        <meta charset="UTF-8">
</head>
<body>
    <form id="form1" name="form1" style="width:300px; height:200px; padding:50px; background-color:activecaption">
    MÜŞTERİ BİLGİLERİ
    <br><br>TC NO:<input type="text" name="tcNo" value="<%=tc%>" style="margin-left:40px;">
    <br>ADI:<input type="text" name="ad" value="<%=name%>" style="margin-left:59px;">
    <br>SOYADI:<input type="text" name="soyad" value="<%=surname%>" style="margin-left:27px;">
    <br>ADRES:<input type="text" name="adres" value="<%=address%>" style="margin-left:35px;">
    <br>TELEFON:<input type="text" name="telefon" value="<%=telephone%>" style="margin-left:17px;">    
    </form>
</body>
</body>
</html>
<%
    }
%>
