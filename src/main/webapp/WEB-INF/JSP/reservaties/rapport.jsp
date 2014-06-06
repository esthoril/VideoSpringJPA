<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!doctype html>
<html lang="nl">

	<head>
		<title>Rapport</title>
		<link rel="stylesheet" href="${contextPath}/styles/default.css"/>
	</head>

	<body>
		<div id="header">
			<c:import url="/WEB-INF/JSP/menus/topmenu.jsp" />
			<div id="titel">Rapport</div>
		</div>
		<div id="left">
			<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
		</div>

		<div id="content">
			<h2>Reservatie</h2>
	
			<c:if test="${empty leeg}">
				<c:if test="${empty nonReservableMovies}">
					De reservatie is OK.
				</c:if>
				<c:if test="${not empty nonReservableMovies}">
					Volgende films zijn niet gereserveerd:
					<ul>
						<c:forEach var="movie" items="${nonReservableMovies}" varStatus="status">
							<li>${movie.titel}</li>
						</c:forEach>
					</ul>
				</c:if>
			</c:if>
			<c:if test="${not empty leeg}">
				${leeg}
			</c:if>
		</div>
	</body>
</html>