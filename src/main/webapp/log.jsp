<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/${requestCookie}.css">
    <title>Jeugdhuis Heidestip - Logboek</title>

</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Logboek"/>
</jsp:include>
<main>
    <section id="leden-section">
        <h2 class="pagina-navigatie">Logboek</h2>

        <div style="overflow-x:auto;">
            <table>
                <thead>
                <tr>
                    <th>Tijd</th>
                    <th>Gezochte email</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="session" items="${logboek}" >
                    <tr>
                        <td>${session.time}</td>
                        <td>${session.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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