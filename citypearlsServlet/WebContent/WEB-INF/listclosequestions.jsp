<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title>List of nearby questions</title>
</head>
<body>
	<h1>Questions nearby</h1>
<div class="list-group">
<c:forEach var="q" items="${questions}">
<a href="#" class="list-group-item active">
	<h4 class="list-group-item-heading"><c:out value="${q.question}"  escapeXml="false"/></h4>
	<p class="list-group-item-text"><c:out value="${q.address}" escapeXml="false"/> </p>
 </a>
</c:forEach>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>