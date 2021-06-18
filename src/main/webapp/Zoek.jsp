<%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 14/03/2021
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="nl">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/${requestCookie}.css">
    <title>Jeugdhuis Heidestip - Zoek Lid</title>

</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Zoek Lid"/>
</jsp:include>

<main>
    <section id="zoek">
        <div class="zoekbody">
        <h2 class="pagina-navigatie">Zoek Lid</h2>
        <form class="contact-form" action="LedenServlet?command=zoek" method="Get" novalidate>

            <div><label for="email">Het gezochte e-mail</label><br>
                <input type="email" id="email" name="email" placeholder="Het gezochte email"><br>
            </div>
            <input type="submit" id="addButton" value="Zoek">
            <input type="hidden"  id="zoekKnop" name="command" value="gevonden">
        </form>
        </div>
    </section>
    <footer>
        <div class="footer">
            <p id="ChangeTheme"><a href="LedenServlet?command=changeTheme">Change theme</a> Thema: ${requestCookie} Mode</p>
        </div>

    </footer>
</main>
</body>
</html>
