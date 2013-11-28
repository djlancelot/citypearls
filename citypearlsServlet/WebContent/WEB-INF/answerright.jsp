<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title>And your answer is RIGHT!</title>
</head>
<body>
	<h1>Good job!</h1>
	<p>You're answer is right.
	<br/>
	Go back to the <a href="UserMenu" class="btn btn-primary">menu</a> to choose another question.<br/>
	</p>
<jsp:include page="footer.jsp" />
</body>
</html>