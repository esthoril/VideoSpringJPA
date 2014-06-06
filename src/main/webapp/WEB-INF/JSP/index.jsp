<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!doctype html>
<html lang="nl">

	<head>
		<link rel="stylesheet" href="${contextPath}/styles/default.css" />
		<title>Video</title>
	</head>
	<body>
	<div id="header">
		<c:import url="/WEB-INF/JSP/menus/topmenu.jsp" />
		<div id="titel">Videotheek</div>
	</div>
	<div id="left">
		<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
	</div>
	
	<div id="content">
		<h2>Info</h2>
		Spring Test <br>
		Sander Hendrickx <br>
		5 juni 2014 <br>
		<br>
		aanpassingen tov Hibernate test (los van de omzetting naar Spring)
		<ul>
		<li>menu geeft ook weer hoeveel verschillende films er zijn per genre </li>
		<li>rechtsboven op de pagina zie je waar je bent </li>
		<li>@NamedStoredProcedureQuery gebruikt (zie oa Reservatie.java) (mogelijk vanaf JPA 2.1) wat buiten de cursus valt</li>
		<li>aparte entiteit gemaakt voor het mandje die lijst films bijhoudt ipv lijst nummers</li>
		<li>klant aanklikken na zoeken zonder dat er films in het mandje zitten geeft dat ook als boodschap</li>
		<li>na bevestigen met browser back knop terug gaan en weer op bevestigen klikken zal nu boodschap geven dat het mandje leeg is</li>
		<li>beter indeling met subfolders van alle .jsp pagina's</li>
		<li>...</li>
		</ul>
	</div>

	</body>
</html>