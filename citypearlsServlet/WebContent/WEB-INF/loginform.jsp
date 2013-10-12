<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Bootstrap -->
  <link href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
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
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="//code.jquery.com/jquery.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>