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
		<h2>Update User Information</h2>
	</div>
	<div align="center">
		<form action="updateUser" method="post">
			<table border="1" cellpadding="5">
			  <tr>
			    <td>Login ID:</td>
			    <td>
			    	<input type="text" name="uloginid" size="45" value='${euser.loginid}' required/>			    					     
			    </td>
			  </tr>
			  <tr>
			    <td>Password:</td>
			    <td>
			    	<input type="password" name="upassword" size="45" value='${euser.password}' required/>
			    </td>
			  </tr>
			  <tr>
			    <td>Email:</td>
			    <td>
			    	<input type="email" name="uemail" size="45" value='${euser.email}' required/>
			    </td>
			  </tr>
			  <tr>
			    <td>Phone/Mobile:</td>
			    <td>
			    	<input type="number" name="uphone" size="45" value='${euser.phone}' required/>
			    </td>
			  </tr>
			  <tr>
			  	<td></td>
			    <td colspan="2" align="center">
					<input type="submit" value="Update User" />
				</td>
			  </tr>
			</table>			
		</form>
	</div>
</body>
</html>
