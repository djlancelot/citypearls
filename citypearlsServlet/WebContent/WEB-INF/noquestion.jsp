<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title>You are out of questions..</title>
</head>
<body>
	<h1>You are out of questions.</h1>
	<p>Why don't you <a href="UserMenu" class="btn btn-primary">choose one</a><br/>
	<c:choose>
	<c:when test="${user.getGroupid() == 1}">
	or <a href="AddQuestion" class="btn btn-primary"><i class="icon-remove"></i> write one</a> for yourself?<br/>
	</c:when>
	<c:otherwise>
	or ask an admin to write one for you?
	</c:otherwise>
	</c:choose>
	</p>
<jsp:include page="footer.jsp" />
</body>
</html>