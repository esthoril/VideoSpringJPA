<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!doctype html>
<html lang="nl">
	<head>
		<link rel="stylesheet" href="${contextPath}/styles/default.css" />
		<script type="text/javascript" src="/nhpup_1.1.js"></script>
		<title>Video</title>
	</head>
	<body>

		<div id="header">
			<c:import url="/WEB-INF/JSP/menus/topmenu.jsp" />
			<div id="titel">${sessionScope.selectedgenre.naam}</div>
		</div>

		<div id="left">
			<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
		</div>

		<div id="content">
			<h2>${aantal} film(s) gevonden:</h2>
			<c:forEach var="movie" items="${movies}" varStatus="status">
				<c:url value="/moviedetail" var="detailURL">
					<c:param name="filmnr" value="${movie.filmNr}"/>
				</c:url>
				<a href="${detailURL}">
					<c:set var="reserve" value="${movie.gereserveerd < movie.voorraad}" />
					<!-- ${movie.titel}<br> -->
					<img src="img/${movie.filmNr}.jpg"
						title="${reserve ? 'reservatie mogelijk' : 'reservatie niet mogelijk' }"
						height="160" alt="${movie.titel}"/>
				</a>
			</c:forEach>
	
		</div>

	</body>
</html>