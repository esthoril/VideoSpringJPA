<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			<div id="titel">Filmdetail</div>
		</div>
		<div id="left">
			<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
		</div>
		<div id="content">
			<h2>${movie.titel}</h2>
			<table>
				<tr>
					<td>
						<img src="img/${movie.filmNr}.jpg" height="320" alt="${movie.titel}"/>
					</td>
					<td class="moviepic">
						<ul>
							<li>Prijs: &euro;${movie.prijs}</li>
							<li>Voorraad: ${movie.voorraad}</li>
							<li>Gereserveerd: ${movie.gereserveerd}</li>
							<li>Beschikbaar: ${movie.isReservable() ? 'Ja' : 'Nee'}</li>
						</ul>

						<c:if test="${movie.isReservable()}">
							<form method="post" action="${contextPath}/order">
								<input type="hidden" name="filmnr" value="${movie.filmNr}" />
								<input type="hidden" name="titel" value="${movie.titel}" />
								<input type="hidden" name="voorraad" value="${movie.voorraad}" />
								<input type="hidden" name="gereserveerd" value="${movie.gereserveerd}" />
								<input type="hidden" name="prijs" value="${movie.prijs}" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="submit" name="mandje" value="In mandje" />
							</form>
						</c:if>
					</td>
				</tr>
			</table>
			
			
		</div>
		
	</body>
</html>