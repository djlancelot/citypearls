<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<title>Login form</title>
</head>
<body>
<p class="text-info">${message}</p>
<form action="Login" method="post" role="form">
<div class="form-group">
<label for="username">Username</label><input type="text" class="form-control" id="username" name="username" value="${username}" placeholder="username">
<label for="password">Password</label><input type="password" class="form-control" id="password" name="password" placeholder="******">
<button type="submit" class="btn btn-primary">Login</button>
</div>
</form>
<jsp:include page="footer.jsp" />

</body>
</html>