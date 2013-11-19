<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Bootstrap -->
  <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="//code.jquery.com/jquery.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>