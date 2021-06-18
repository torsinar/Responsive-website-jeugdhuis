<%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 14/03/2021
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="nl">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/${requestCookie}.css">
    <title>Jeugdhuis Heidestip - Gevonden Lid</title>
</head>
<body>
    <jsp:include page="header.jsp">
        <jsp:param name="hier" value="Zoek lid"/>
    </jsp:include>
    <main>
        <section>
            <h1>Gevonden</h1>
            <p>Je zocht ${vnaam} ${anaam} op:</p>
            <p id="gegevens">${string}</p>
        </section>
        <footer>
            <div class="footer">
                <p id="ChangeTheme"><a href="LedenServlet?command=changeTheme">Change theme</a> Thema: ${requestCookie} Mode</p>
            </div>

        </footer>
    </main>

</body>
</html>
