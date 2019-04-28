<jsp:useBean id="bean1" class="Database.Connect" scope="session" />
<%@page import="Database.*, java.util.*, java.text.DecimalFormat, java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            String ara = request.getParameter("arama");
         
            if (ara != null) {
                String tcNo = request.getParameter("tcNo");
                System.out.println("TC=" + tcNo);
                ResultSet rs = bean1.KayitArama(tcNo);
                if (rs != null) {                                    
                    while (rs.next()) {
                       //String tcNo = rs.getString("kimlikNo");                        
                       String isim = rs.getString("ad");
                       String soyisim = rs.getString("soyad");
                       String adres = rs.getString("adres");
                       String telefon = rs.getString("telefon");  
                       System.out.println("tc kimlik no="+tcNo+" "+"isim=" + isim +" "+ "soyisim=" +soyisim+" "+ "adres=" +adres+ " telefon=" +telefon);  

                       if ( isim!= null) {
                            session.setAttribute("kimlikNo", tcNo);
                            session.setAttribute("ad",isim);
                            session.setAttribute("soyad",soyisim);
                            session.setAttribute("adresi",adres);
                            session.setAttribute("telefonu",telefon);
                            %>
<jsp:forward page="arama.jsp">    
    <jsp:param name="sayfa" value="deger"></jsp:param>
</jsp:forward>
<%
                        }                                    
                    }
                }   
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
        <br><br><input type="submit" name="arama" value="ARA">
    </form>
</body>
</html>
