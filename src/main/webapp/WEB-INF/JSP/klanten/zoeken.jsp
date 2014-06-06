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
		<div id="titel">Klanten zoeken</div>
	</div>

	<div id="left">
		<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
	</div>
	
	<div id="content">
		<h2>Klant</h2>
		<c:url value="/klanten/zoeken" var="url"/>
		<form method="get" action="${url}">
			<label>Familienaam bevat:
			<input name="naam" value="${param.naam}"/>
			<span class="fout">${fout.naam}</span></label>
			<input type="submit" value="Zoeken"/>
		</form>
		<br>
		<c:if test="${not empty klanten}">
			<table>
				<tr>
					<th>Naam</th>
					<th>Straat - huisnummer</th>
					<th>Postcode</th>
					<th>Gemeente</th>
				</tr>
				<c:forEach var="klant" items="${klanten}">
				<tr>
					<td>
						<c:url value="/klanten/bevestigen" var="bevestigURL">
							<c:param name="klantnr" value="${klant.klantNr}"/>
						</c:url>
						<a href="${bevestigURL}"> ${klant.voornaam} ${klant.familienaam}</a>
					</td>
					<td>${klant.straatNummer}</td>
					<td>${klant.postcode}</td>
					<td>${klant.gemeente}</td>
				</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>