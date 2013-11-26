<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="//code.jquery.com/jquery.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
   <script type="text/javascript">
   console.log("java started");
  $(function() {
	console.log("jquery ready");
	
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
		console.log("adding position");
		var lat = position.coords.latitude;
		var lng = position.coords.longitude;
		var head = position.coords.heading;
		console.log("adding position lat: "+lat+" lng: "+ lng + " heading: "+head);
		$("a.addnav").each(function(){
			this.href = this.href+"?lat="+lat+"&lng="+lng + "&head="+head;
		});
	    
	  }
	
  });
  </script>