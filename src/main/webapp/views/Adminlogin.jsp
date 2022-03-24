<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes</title>
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
	<div align="center">
		<h2>Admin Login</h2>
	</div>
	<div align="right">
		<a href="/index">Sign Out</a>
	</div>
	<div align="center">
		<form action="validateAdmin" method="post">
			<table border="1" cellpadding="5">
			  <tr>
			    <td>Login ID:</td>
			    <td><input type="text" placeholder="Enter Username" name="username" required></td>
			  </tr>
			  <tr>
			    <td>Password:</td>
			    <td><input type="password" placeholder="Enter Password" name="userpassword" required></td>
			  </tr>
			  <tr>
			  	<td></td>
			    <td><input type="submit" value="Login"></td>
			  </tr>
			</table>			
		</form>
	</div>
</body>
</html>
