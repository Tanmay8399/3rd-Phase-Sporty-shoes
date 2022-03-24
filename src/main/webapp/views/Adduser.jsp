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
	<h2>Sign Up</h2>
	<div align="left">
		<a href="/index">Back to Main Page</a>
	</div>
	<div align="center">
		<form action="signUpUser" method="post">
			<table border="1" cellpadding="5">
			  <tr>
			    <td>Login ID:</td>
			    <td><input type="text" placeholder="Enter Username" name="loginid" required></td>
			  </tr>
			  <tr>
			    <td>Password:</td>
			    <td><input type="password" placeholder="Enter Password" name="password" required></td>
			  </tr>
			  <tr>
			    <td>Email:</td>
			    <td><input type="email" placeholder="abc@xyz.com" name="email" required></td>
			  </tr>
			  <tr>
			    <td>Phone/Mobile:</td>
			    <td><input type="number" placeholder="0501234567" name="phone" required></td>
			  </tr>
			  <tr>
			  	<td></td>
			    <td><input type="submit" value="Sign Up"></td>
			  </tr>
			</table>			
		</form>
	</div>
</body>
</html>
