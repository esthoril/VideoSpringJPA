<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!doctype html>
<html lang="nl">
<head>
	<title>Films bestellen</title>
	<link rel="stylesheet" href="${contextPath}/styles/default.css"/>
</head>
<body>

	<div id="header">
		<c:import url="/WEB-INF/JSP/menus/topmenu.jsp" />
		<div id="titel">Winkelmandje</div>
	</div>
	<div id="left">
		<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
	</div>

	<div id="content">
		<h2>Overzicht mandje</h2>
		${fout}
		<c:if test="${not empty movieList}">
			<c:url value="/order" var="url" />
			<form method="post" action="${url}">
				<table border="1">
					<tr>
						<th>Film</th>
						<th>Prijs</th>
						<th><input type="submit" value="Verwijderen" /></th>
					</tr>
					<c:forEach var="movie" items="${movieList}">
					<tr>
						<td>${movie.titel}</td>
						<td>&euro;${movie.prijs}</td>
						<td class="center"><input type="checkbox" name="nummer" value="${movie.filmNr}"/></td>
					</tr>
					</c:forEach>
					<tr>
						<td style="text-align:right" colspan="3">totaal: &euro;${totaal}&nbsp;&nbsp;</td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${empty movieList}">
			geen films in mandje
		</c:if>
	</div>
</body>
</html>