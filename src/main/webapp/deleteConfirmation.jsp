<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html lang="nl">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Jeugdhuis Heidestip</title>
	<link rel="stylesheet" href="css/reset.css">
	<link type="text/css" href="css/style.css" rel="stylesheet" />
	<link rel="stylesheet" href="css/${requestCookie}.css">
</head>
<body>
	<div id="container">
	<jsp:include page="header.jsp">
		<jsp:param name="hier" value="Leden"/>
	</jsp:include>
	<main>
		<section id="deleteConf">
		<h2>Bevestiging</h2>
		<p>Ben je zeker dat je het lid met email ${param.email}  wilt verwijderen? </p>
		<form action="LedenServlet?command=delete&email=${param.email}" method="POST">
			<input type="submit" id="addButton" value="Ja"/>
		</form>
		<p><a href="LedenServlet?command=leden" id="Cancel">Cancel</a> indien je ${param.email} niet wil verwijderen.</p>
		</section>
	</main>
	</div>
</body>
</html>