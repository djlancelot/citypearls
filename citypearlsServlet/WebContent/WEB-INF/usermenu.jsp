<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title><c:out value="${username}"/>'s adventure for the pearls of the city</title>
</head>
<body>
	<h1>Hello <c:out value="${username}"/>,</h1>
	<p>what's next?<br/>
	<a href="#" class="btn btn-primary"><i class="icon-arrow-left"></i> Back to last question</a><br/>
	<a href="#" class="btn btn-primary"><i class="icon-road"></i> Choose from nearest questions</a><br/>
	<a href="#" class="btn btn-primary"><i class="icon-gift"></i> Get random question</a><br/>
	or maybe you want to <br/>
	<a href="Logout" class="btn btn-primary"><i class="icon-remove"></i> Log out</a><br/>
	</p>
<jsp:include page="footer.jsp" />
</body>
</html>