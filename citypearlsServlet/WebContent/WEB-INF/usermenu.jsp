<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title><c:out value="${user.getUsername()}"/>'s adventure for the pearls of the city</title>
</head>
<body>
	<h1>Hello <c:out value="${user.getUsername()}"/>,</h1>
	<p>
	I see, you've scored <strong><c:out value="${user.getScore()}"/></strong> so far.<br/>
	What's next?<br/>
	<a href="ViewQuestion" class="btn btn-primary"><i class="icon-arrow-left"></i> Back to last question</a><br/>
	<a href="ListCloseQuestions" id="addnav" class="addnav btn btn-primary"><i class="icon-road"></i> Choose from nearest questions</a><br/>
	<a href="SetQuestion" class="btn btn-primary"><i class="icon-gift"></i> Get random question</a><br/>
	<c:if test="${user.getGroupid() == 1}">
	You can also <a href="AddQuestion" class="btn btn-primary"><i class="icon-remove"></i> add questions</a>, if you like.<br/>
	</c:if>
	or maybe you want to <br/>
	Check out the <a href="ScoreList" class="btn btn-primary">leaderboard</a><br/>
	or simply <a href="Logout" class="btn btn-primary"><i class="icon-remove"></i> Log out</a><br/>
	</p>
<jsp:include page="footer.jsp" />
<script type="text/javascript">
   console.log("javascript started");
	var nav = document.getElementById("addnav");  
	if (navigator.geolocation)
	  {
	  console.log("geolocation available");
	  navigator.geolocation.getCurrentPosition(addPosition);
	  }
	else{
		console.log("geolocation is not available");
		alert("Enable geolocation to play!");
	}
	
	function addPosition(position)
	  {
		var lat = position.coords.latitude;
		var lng = position.coords.longitude;
		var head = position.coords.heading;
		console.log("adding position lat: "+lat+" lng: "+ lng + " heading: "+head);
		//$("a.addnav").each(function(){
			nav.href = nav.href+"?lat="+lat+"&lng="+lng + "&head="+head;
		//});
	    
	  }
 
  </script>
</body>
</html>