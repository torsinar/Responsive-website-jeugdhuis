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
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/${requestCookie}.css">
    <title>Jeugdhuis Heidestip - Word Lid</title>

</head>

<body id="word-lid">
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Word lid"/>
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
<div class="wordLidBody">
        <h2 class="pagina-navigatie">Word Lid</h2>
        <form class="contact-form" action="LedenServlet?command=add" method="POST" novalidate>

            <div><label for="vnaam">Voornaam (*)</label> <br>
                <input type="text" id="vnaam" name="vnaam" placeholder="Je voornaam"
                       value="${vnaamPreviousValue}"><br>
            </div>
            <div>
                <label for="anaam">Naam (*)</label><br>
                <input type="text" id="anaam" name="anaam" placeholder="Je achternaam"
                       value="${anaamPreviousValue}"><br>
            </div>

            <div><label for="email">E-mail (*)</label><br>
                <input  id="email" name="email" placeholder="Je E-mail" type="email"
                       value="${emailPreviousValue}"><br>
            </div>

            <div><label for="leeftijd">Leeftijd (*)</label><br>
                <input type="number" id="leeftijd" name="leeftijd" placeholder="Je leeftijd"
                       value="${leeftijdPreviousValue}"><br>
            </div>

            <div><label for="straat">Straat (*)</label><br>
                <input type="text" id="straat" name="straat" placeholder="Je straat"
                       value="${straatPreviousValue}"><br>
            </div>

            <div><label for="huisnummer">Huisnummer (*)</label><br>
                <input type="number" id="huisnummer" name="huisnummer" placeholder="Je huisnummer"
                       value="${huisnummerPreviousValue}"><br>
            </div>

            <div ><label for="bus">Busnummer</label><br>
                <input type="number" id="bus" name="bus" placeholder="Busnummer"
                       value="${busnummerPreviousValue}"><br>
            </div>

            <div ><label for="stad">Stad/Dorp (*)</label><br>
            <input type="text" id="stad" name="stad" placeholder="Je stad/dorp"
                   value="${stadPreviousValue}"><br>

            <input type="submit" id="addButton" value="Verzend">
            </div>
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
