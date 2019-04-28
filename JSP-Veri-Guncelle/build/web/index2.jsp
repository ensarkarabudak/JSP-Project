<jsp:useBean id="bean1" class="Database.Connect" scope="session" />
<%@page import="Database.*, java.util.*, java.text.DecimalFormat, java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            String guncelleme = request.getParameter("guncelle");
         
            if (guncelleme != null) {
                String tcNo = request.getParameter("tcNo");
                String isim = request.getParameter("isim");
                String soyisim = request.getParameter("soyisim");
                String adresi = request.getParameter("adres");
                String telefonu = request.getParameter("telefon");
                System.out.println("TC=" + tcNo);
                bean1.KayitGuncelle(tcNo,isim,soyisim,adresi,telefonu);
%>
<jsp:forward page="guncelleme.jsp">    
    <jsp:param name="sayfa2" value="deger2"></jsp:param>
</jsp:forward>
<%
            }                                                                
%>
<html>
<head>
    <title>MUSTERI BILGILERI</title>
    <meta charset="UTF-8">
</head>
<body>
    <form id="form1" name="form1" method="post" action="" style="width:300px; height:200px; padding:50px; background-color:activecaption">
        MUSTERI BILGILERI
        <br><br>TC NO:<input type="text" name="tcNo" placeholder="TC KİMLİK NO" style="margin-left:40px;">
        <br>ADI:<input type="text" name="isim" placeholder="AD" style="margin-left:59px;">
        <br>SOYADI:<input type="text" name="soyisim" placeholder="SOYAD" style="margin-left:27px;">
        <br>ADRES:<input type="text" name="adres" placeholder="ADRES" style="margin-left:35px;">
        <br>TELEFON:<input type="text" name="telefon" placeholder="TELEFON" style="margin-left:17px;"> 
        <br><br><input type="submit" name="guncelle" value="GUNCELLE">
    </form>
</body>
</html>
