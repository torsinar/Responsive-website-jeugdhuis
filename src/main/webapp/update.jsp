<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: emile
  Date: 21/02/2021
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/${requestCookie}.css">
    <title>Jeugdhuis Heidestip</title>

</head>

<body id="word-lid">
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Leden"/>
</jsp:include>

<main>
    <section>

        <c:if test="${not empty errors}">
            <div>
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>


        <h2 class="pagina-navigatie">Update</h2>
        <p>Gegevens van ${email} wijzigen:</p>
        <form class="contact-form" action="LedenServlet?command=doUpdate&email=${email}" method="POST">

            <div><label for="vnaam">Voornaam (*)</label> <br>
                <input type="text" id="vnaam" name="vnaam" placeholder="Je voornaam"
                       value="${vnaam}"><br>
            </div>
            <div>
                <label for="anaam">Naam (*)</label><br>
                <input type="text" id="anaam" name="anaam" placeholder="Je achternaam"
                       value="${anaam}"><br>
            </div>

            <div><label for="leeftijd">Leeftijd (*)</label><br>
                <input type="number" id="leeftijd" name="leeftijd" placeholder="Je leeftijd"
                       value="${leeftijd}"><br>
            </div>

            <div><label for="straat">Straat (*)</label><br>
                <input type="text" id="straat" name="straat" placeholder="Je straat"
                       value="${straat}"><br>
            </div>

            <div><label for="huisnummer">Huisnummer (*)</label><br>
                <input type="number" id="huisnummer" name="huisnummer" placeholder="Je huisnummer"
                       value="${huisnummer}"><br>
            </div>

            <div ><label for="bus">Busnummer</label><br>
                <input type="number" id="bus" name="bus" placeholder="Busnummer"
                       value="${bus}"><br>
            </div>

            <label for="stad">Stad/Dorp (*)</label><br>
            <input type="text" id="stad" name="stad" placeholder="Je stad/dorp"
                   value="${stad}"><br>
            <input type="submit" id="addButton" value="Verzend">
        </form>


    </section>
</main>

</body>

</html>
