<%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 14/03/2021
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="nl">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/${requestCookie}.css">
    <title>Jeugdhuis Heidestip - LidNietGevonden</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Zoek lid"/>
</jsp:include>
<main>
    <section id="nietGevonden">
        <h1>Lid niet gevonden.</h1>
    </section>

</main>


</body>
</html>
