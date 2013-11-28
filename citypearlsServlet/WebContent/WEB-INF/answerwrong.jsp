<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title>And your answer is WRONG!</title>
</head>
<body>
	<h1>There is something wrong...</h1>
	<p>Why don't you <a href="ViewQuestion" class="btn btn-primary">try again</a>?
	</p>
<jsp:include page="footer.jsp" />
</body>
</html>