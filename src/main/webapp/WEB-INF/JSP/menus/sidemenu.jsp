<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
		
	<%-- houdt bij welke link actief is en geeft die knop een andere kleur --%>
	Genre (aantal)
	<ul id="genremenu">
		<c:forEach var="gen" items="${sessionScope.genres}" varStatus="status">
			<c:set var="nummer" value="${sessionScope.selectedgenre.genreNr}"/>
			<li class="${gen.genreNr == nummer ? 'selected' : ''}">
				<c:url var="genreURL" value="/genre">
					<c:param name="nr" value="${gen.genreNr}"/>
				</c:url>
				<a href="${genreURL}">${gen.naam} (${gen.aantal})</a>
			</li>
		</c:forEach>
	</ul>

</header>