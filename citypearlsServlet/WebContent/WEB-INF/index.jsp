<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title>Adventure for the pearls of the city</title>
</head>
<body>
	<h1>Hi there,</h1>
	<p>to explore the secret pearls of the city,</p>  
	<ol>
		<li>you should <a href="Register" class="btn btn-primary">register</a>.</li>
		<li>If you've already did that, please 	<a href="Login" class="btn btn-primary">log in</a>.</li>
		<li>You might find the <a href="ScoreList" class="btn btn-primary">leaderboard</a> interesting.</li>
	</ol>

<jsp:include page="footer.jsp" />
</body>
</html>