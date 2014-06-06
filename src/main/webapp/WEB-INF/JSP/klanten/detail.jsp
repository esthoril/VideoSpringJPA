<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
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
			<div id="titel">Klantdetail</div>
		</div>
		<div id="left">
			<c:import url="/WEB-INF/JSP/menus/sidemenu.jsp" />
		</div>
		<div id="content">
		
			<h2>Gegevens klant</h2>
		
			<table>
				<col width="30%">
				<col width="70%">
				<tr><th>gegevens</th><th></th></tr>
				<tr><td align="right">Voornaam: </td><td>${klant.voornaam}</td></tr>
				<tr><td align="right">Familienaam: </td><td>${klant.familienaam}</td></tr>
				<tr><td align="right">Straatnummer: </td><td>${klant.straatNummer}</td></tr>
				<tr><td align="right">Postcode: </td><td>${klant.postcode}</td></tr>
				<tr><td align="right">Gemeente: </td><td>${klant.gemeente}</td></tr>
			</table>
		</div>
		
	</body>
</html>