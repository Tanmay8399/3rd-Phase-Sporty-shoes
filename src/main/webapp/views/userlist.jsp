<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div align="left">
		<a href="/adminpage">Back to Admin Page</a>
	</div>
	<div align="center">
		<form action="/edituser" method="post">
			<table border="1" cellpadding="5">
				<caption><h2>List of Users</h2></caption>
	            <tr>
	                <th>Login ID</th>
	                <th>Email</th>
	                <th>Phone/Mobile</th>
	            </tr>
	            <c:forEach var="Users" items="${Users}">
	                <tr>
	                    <td><c:out value="${Users.loginid}" /></td>
	                    <td><c:out value="${Users.email}" /></td>
	                    <td><c:out value="${Users.phone}" /></td>
	                    <td>
	                    	<a href="/edituser?lid=<c:out value='${Users.loginid}' />">Edit Info</a>
	                    </td>
	                </tr>
	            </c:forEach>
			</table>
		</form>
	</div>
</body>
</html>
