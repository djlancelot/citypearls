<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<title>Register form</title>
</head>
<body>
<p class="text-info" id="message">${message}</p>
<form action="Register" method="post" role="form">
<div class="form-group">
<label for="username">User name</label><input type="text" class="form-control" id="username" name="username" value="${username}" placeholder="username">
<label for="email">E-mail address</label><input type="text" class="form-control" id="email" name="email" value="${email}" placeholder="email@address">
<label for="password">Password</label><input type="password" class="form-control" id="password" name="password" placeholder="******">
<label for="password2">Password again</label><input type="password" class="form-control" id="password2" name="password2" placeholder="******">
<button type="submit" class="btn btn-primary">Register</button>
</div>
</form>
<jsp:include page="footer.jsp" />
<script type="text/javascript">
$(document).ready(function () {
	   $("#password2").keyup(checkPasswordMatch);	   
});

var checkPasswordMatch = function(){
    var password = $("#password").val();
    var confirmPassword = $("#password2").val();

    if (password != confirmPassword)
        $("#message").html("Passwords do not match!");
    else
        $("#message").html("Passwords match.");
}; 
</script>
</body>
</html>