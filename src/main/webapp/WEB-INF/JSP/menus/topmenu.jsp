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
		<ul id="menu">
			<li><c:url value="/" var="homeURL"/>
			<a href="${homeURL}">Home</a></li>
			<li><c:url value="/order" var="mandjeURL"/>
			<a href="${mandjeURL}">Mandje</a></li>
			<li><c:url value="/klanten/zoeken" var="klantURL"/>
			<a href="${klantURL}">Klanten</a></li>
			<li><c:url value="/reservaties/overzicht" var="reservatieURL"/>
			<a href="${reservatieURL}">Reservaties</a></li>
		</ul>
	</body>
</html>