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
    <title>Jeugdhuis Heidestip - Leden</title>

</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Leden"/>
</jsp:include>
<main>
    <section id="leden-section">
        <h2 class="pagina-navigatie">Leden</h2>

        <p>De gemiddelde leeftijd van de leden is ongeveer ${gemLeeftijd} jaar.</p>

        <div style="overflow-x:auto;">
            <table>
                <thead>
                <tr>
                    <th>Voornaam</th>
                    <th>naam</th>
                    <th>E-mail</th>
                    <th>Leeftijd</th>
                    <th>Straat</th>
                    <th>Huisnummer</th>
                    <th>Busnummer</th>
                    <th>Stad</th>
                    <th>Pas aan</th>
                    <th>Verwijder</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="lid" items="${alleLeden}">
                <tr>
                    <td>
                        ${lid.voornaam}
                    </td>
                    <td>
                        ${lid.naam}
                    </td>
                    <td>
                        ${lid.email}
                    </td>
                    <td>
                        ${lid.leeftijd}
                    </td>
                    <td>
                        ${lid.straat}
                    </td>
                    <td>
                        ${lid.huisnummer}
                    </td>
                    <c:choose>
                    <c:when test = "${lid.busnummer==0}" >
                        <td>

                        </td>
                    </c:when>

                    <c:otherwise>
                        <td>
                                ${lid.busnummer}
                        </td>
                    </c:otherwise>
                    </c:choose>


                    <td>
                            ${lid.stad}
                    </td>
                    <td><a href="LedenServlet?command=update&vnaam=${lid.voornaam}&anaam=${lid.naam}&email=${lid.email}&leeftijd=${lid.leeftijd}&straat=${lid.straat}&huisnummer=${lid.huisnummer}&bus=${lid.busnummer}&stad=${lid.stad}">Pas aan</a></td>
                    <td><a href="LedenServlet?command=deleteConfirmation&email=${lid.email}">Verwijder</a></td>
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
