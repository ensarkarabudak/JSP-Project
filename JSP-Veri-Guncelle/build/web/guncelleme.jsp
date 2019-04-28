
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String sayfa2 = (String) request.getParameter("sayfa2");
//out.println(sayfa);

if(sayfa2.equalsIgnoreCase("deger2"))
    out.print("Güncelleme başarılı!!!");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>GUNCELLEME</title>
</head>
<body>
    <h1></h1>
</body>
</html>
