<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/${requestCookie}.css">
    <title>Jeugdhuis Heidestip - Home</title>


</head>

<body id="home">
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Home"/>
</jsp:include>
<main>
    <div class="banner-container">
        <img src="img/banner.jpg" alt="bestuursleden">
    </div>

    <section>
        <div  class="pagina-navigatie"><h2>Home</h2></div>
        <div class="info">
            <h1>Jeugdhuis Heidestip</h1>
            <p>Als bestuursleden van jeugdhuis heidestip proberen we zoveel mogelijk activiteiten te organiseren voor onze Londerzeelse jeugd.</p>

        </div>
        <div class="extra-info">
            <h1>Heroprichting</h1>
            <p>Na het sluiten van het jeugdhuis "Heidestip" in 2013 hebben we besloten nieuw leven in het jeugdhuis te blazen. sinds 2018 zijn onze
                bestuursleden en vrijwilligers hard aan het werk om dit mooie jeugdhuis weer helemaal populair te maken. Heb jij interesse om lid te
                worden? Je kan een lidkaart aankopen of je inschrijven als vrijwilliger. </p>

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