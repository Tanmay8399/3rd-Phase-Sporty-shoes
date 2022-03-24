<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes</title>

	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	 <script>  $( function() {$( "#datepicker" ).datepicker();  } );  </script>
  	 
</head>
<style >

body {
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 400% 400%;
	animation: gradient 15s ease infinite;
	height: 100vh;
}

@keyframes gradient {
	0% {
		background-position: 0% 50%;
	}
	50% {
		background-position: 100% 50%;
	}
	100% {
		background-position: 0% 50%;
	}
}

h1 {
    text-align: center;
}
h2 {
    text-align: center;
}

</style>
<body>
	<h1>Welcome to Sporty Shoes</h1>
	<div align="right">
		<a href="/index">Sign Out</a>
	</div>
	<div align="center">
		<h2>Purchase Report</h2>
	</div>
	<div align="center">
		<h2>Provide Search Criteria</h2>
	</div>
	<div align="center">
		<form action="callReport" method="post">
			<table border="1" cellpadding="5">
			  <tr>
			    <td>Select Brand:</td>
			    <td><input type="text" placeholder="Enter Brandname" name="rbrand" required></td>
			  </tr>
			  <tr>
			    <td>Date of Purchase:</td>
			    <td><input type="date" class="form-control" id="datepicker" name="rdate"></td>
			  </tr>
			  <tr>
			  	<td></td>
			    <td><input type="submit" value="Show Report"></td>
			  </tr>
			</table>			
		</form>
	</div>

</body>
</html>
