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
		<div id="titel">Reservaties</div>
	</div>
	<div id="left">
		<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
	</div>

	<div id="content">
		<h2>Overzicht alle reservaties</h2>
		<c:if test="${empty reservaties}">
			Geen reservaties.
		</c:if>
		KlantNr en FilmNr linken naar de bijhorende detailpagina.
		<br>
		<br>
		<c:if test="${not empty reservaties}">
			<table>
				<tr>
					<th>KlantNr</th>
					<th>FilmNr</th>
					<th>Datum</th>
				</tr>
				<c:forEach var="res" items="${reservaties}" varStatus="status">
				<tr>
					<td align="center">
						<c:url value="/klanten/detail" var="klantURL">
							<c:param name="klantnr" value="${res.klantNr}"/>
						</c:url>
						<a href="${klantURL}">${res.klantNr}</a>
					</td>
					<td align="center">
						<c:url value="/moviedetail" var="filmURL">
							<c:param name="filmnr" value="${res.filmNr}"/>
						</c:url>
						<a href="${filmURL}">${res.filmNr}</a>
					</td>
					<td>${res.datum}</td>
				</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>		
</body>
</html>