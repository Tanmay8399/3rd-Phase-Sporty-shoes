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
	<h2>Hello, ${username}</h2>
	<div align="center">
		<h3>Your Cart</h3>
	</div>
	<div align="right">
		<a href="/index">Sign Out</a>
	</div>
	<div align="right">
		<a href="/userPage?&username=<c:out value='${username}' />">Add More Items</a>
	</div>
	<div align="center">
		<form action="/placeOrder" method="post">
			<table border="1" cellpadding="5">
				<caption><h3>Items in your cart</h3></caption>
	            <tr>
	                <th>Brand</th>
	                <th>Category</th>
	                <th>Size</th>
	                <th>Price</th>
	            </tr>
	            <c:forEach var="cart" items="${cart}">
	                <tr>
	                    <td><c:out value="${cart.brandname}" /></td>
	                    <td><c:out value="${cart.gender}" /></td>
	                    <td><c:out value="${cart.size}" /></td>
	                    <td><c:out value="${cart.price}" /></td>
	                </tr>	                
	            </c:forEach>
	            <tr>
	            	<th>Cart Total</th>
	            	<th></th>
	            	<th></th>
	            	<td>${carttotal}</td>
	            </tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
                	<td>
                		<a href="/placeOrder?&lid=<c:out value='${username}' />">Place Order</a>
                	</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
