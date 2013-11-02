<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title>List of Scores on the page</title>
</head>
<body>
	<h1>Score list</h1>
	<table class="table table-striped">
<thead><tr><td>Score</td><td>Name</td></tr></thead>
<c:forEach var="userscore" items="${userscores}">
<tbody>
<tr>
<td><c:out value="${userscore.score}"/></td>
<td><c:out value="${userscore.username}"/> </td>
</tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="footer.jsp" />
</body>
</html>