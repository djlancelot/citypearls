<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title><c:out value="${user.getUsername()}"/>'s question</title>
</head>
<body>
	<p>Answer the question to solve the myth. There is some hint <strong><span id="distance"></span></strong>.
	The address is <strong><c:out value="${question.address}" escapeXml="false"/></strong></p>
	<h1><c:out value="${question.question}" escapeXml="false"/></h1>
	<p><c:out value="${question.description}" escapeXml="false"/></p>
	<img alt="Hint" class="img-thumbnail" src="<c:out value="${question.banner}" escapeXml="false"/>"/>
<form action="AnswerQuestion" method="post" role="form">
	<div class="form-group">
	<label for="answer">Answer</label><input type="text" class="form-control" id="answer" name="answer" value="" placeholder="I donno">
	<button type="submit" class="btn btn-primary">Answer</button>
	</div>
</form>
		
<jsp:include page="footer.jsp" />
<script type="text/javascript">
   console.log("javascript started");
   var distance = document.getElementById("distance");
   var qlat = <c:out value="${question.latitude}" escapeXml="false"/>;
   var qlng = <c:out value="${question.longtitude}" escapeXml="false"/>;
   var radians = function(x){
	   return x*Math.PI/180.0;
   }
   var calcDistance = function(tlat,tlng,llat,llng){	   
	   var a1 = Math.sin(radians(llat-tlat)/2)*Math.sin(radians(llat-tlat)/2);
	   var a2 = Math.sin(radians(llng-tlng)/2)*Math.sin(radians(llng-tlng)/2);
	   var a3 = Math.cos(radians(tlat))*Math.cos(radians(llat));
	   var result = Math.asin(Math.sqrt(a1+a2*a3))*12756.2;
	   return result;
   }
   /*
   CREATE OR REPLACE FUNCTION geodistance(alat double precision, alng double precision, blat double precision, blng double precision) RETURNS double precision AS
   $BODY$
   SELECT asin(
     sqrt(
       sin(radians($3-$1)/2)^2 +
       sin(radians($4-$2)/2)^2 *
       cos(radians($1)) *
       cos(radians($3))
     )
   ) * 12756.2 AS distance;
   $BODY$
   */
   var delayReRead =  function(){
	   setTimeout(readPosition,1000); // read pos. in 1 sec
   }
   var parsePosition = function(position)
	  {
		console.log("parsing position");
		var lat = position.coords.latitude;
		var lng = position.coords.longitude;
		var head = position.coords.heading;
		var dist = calcDistance(lat,lng,qlat,qlng);
		console.log("positions lat: "+lat+" lng: "+ lng + " heading: "+head);
		
		console.log("distance " + dist);
		if(dist<0.1){
			distance.innerHTML = "somewhere here";
		}else{
			distance.innerHTML = " in " + dist.toFixed(2) + " km";
		}
		delayReRead();
	  }
   var readPosition = function (){
	   console.log("reading geolocation");
	   navigator.geolocation.getCurrentPosition(parsePosition);
   }
   if (navigator.geolocation)
	{
		readPosition();
	}	else{
			console.log("geolocation is not available");
			alert("Enable geolocation to play!");
 	}
  
  </script>
</body>
</html>