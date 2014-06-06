<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!doctype html>
<html lang="nl">

	<head>
		<title>Klanten</title>
		<link rel="stylesheet" href="${contextPath}/styles/default.css"/>
	</head>

	<body>
		<div id="header">
			<c:import url="/WEB-INF/JSP/menus/topmenu.jsp" />
			<div id="titel">Bevestigen</div>
		</div>
		<div id="left">
			<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
		</div>
		<div id="content">
			<h2>Bevestigen</h2>
			<c:if test="${not empty movieList}">
				${movieList.size()} film(s) voor ${klant.voornaam} ${klant.familienaam} <br>
				<br>
				<ul>
					<c:forEach var="movie" items="${movieList}" varStatus="status">
						<li>${movie.titel}</li>
					</c:forEach>
				</ul>
				<c:url value="/reservaties/rapport" var="rapportURL"/>
				<form action="${rapportURL}" method="get">
					<input type="hidden" name="klantnr" value="${klant.klantNr}" />
			    	<input type="submit" value="Bevestig" />
				</form>
			</c:if>
			<c:if test="${empty movieList}">
				Nog geen films in mandje!
			</c:if>
			
		</div>
	</body>

</html>