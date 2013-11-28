<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<title>Add question form</title>
 <style type="text/css">
      #map-canvas { height: 360px; width: 100%; }
    </style>
    <script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCGf18lSIbE95a4kHycQBbscMgRjLh0SVw&sensor=false">
    </script>
    <script type="text/javascript">
      function initialize() {
    	var myLatlng = new google.maps.LatLng(47.48171267245574, 19.056150913238525);
        var mapOptions = {
          center: myLatlng,
          zoom: 8
        };
        var map = new google.maps.Map(document.getElementById("map-canvas"),
            mapOptions);
        var marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            title:"Here it is"
        });
        var changemarker = function(e){
        	var pos = e.latLng;
        	var latTxt = document.getElementById("latitude");
        	var longTxt = document.getElementById("longtitude");
        	marker.setPosition(pos);
        	map.panTo(pos);
        	latTxt.value = pos.lat();
        	longTxt.value = pos.lng();
        	
        	
        }
        google.maps.event.addDomListener(map, 'click', changemarker);
      }      
      
      google.maps.event.addDomListener(window, 'load', initialize);
      
    </script>
</head>
<body>
<p class="text-info" id="message">${message}</p>
<form action="AddQuestion" method="post" role="form">
<div class="form-group">
<label for="question">Question</label><input type="text" class="form-control" id="question" name="question" placeholder="What does the sign say?">
<label for="answer">Answer</label><input type="text" class="form-control" id="answer" name="answer" placeholder="In memories of the brave programmers, or second answer separeted by a comma">
<label for="description">Description</label><textarea class="form-control" id="description" name="description" rows="3" placeholder="Placed in 2013 by unknown supproters."></textarea>
<label for="point">Point for good answer</label><input type="text" class="form-control" id="point" name="point" placeholder="10">
<label for="banner">Banner url</label><input type="text" class="form-control" id="banner" name="banner" value="https://admissionblog.usc.edu/files/2013/05/Question-Mark.jpg">
<label for="address">Address</label><input type="text" class="form-control" id="address" name="address"  placeholder="1111 Budapest, Muegyetem rakpart 1-3.">
<label for="latitude">Latitude</label><input type="text" class="form-control" id="latitude" name="latitude"  placeholder="47.48171267245574">
<label for="longtitude">Longtitude</label><input type="text" class="form-control" id="longtitude" name="longtitude" placeholder="19.056150913238525">
<button type="submit" class="btn btn-primary">Add</button>
</div>
<div id="map-canvas"></div>
</form>
<jsp:include page="footer.jsp" />
</body>
</html>