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
	<div align="right">
		<a href="/adminpage">Back to Admin Page</a>
	</div>
	<div align="right">
		<a href="/reportparam">Change Search</a>
	</div>
	<div align="center">
		<form>
			<table border="1" cellpadding="5">
				<caption><h3>Purchase Report</h3></caption>
	            <tr>
	            	<th>Customer</th>
	            	<th>Order #</th>
	            	<th>Order Date</th>
	                <th>Brand</th>
	                <th>Category</th>
	                <th>Size</th>
	                <th>Price</th>
	            </tr>
	            <c:forEach var="purchasedetails" items="${purchasedetails}">
	                <tr>
	                	<td><c:out value="${purchasedetails.loginid}" /></td>
	                	<td><c:out value="${purchasedetails.orderid}" /></td>
	                	<td><c:out value="${purchasedetails.orderdate}" /></td>
	                    <td><c:out value="${purchasedetails.brandname}" /></td>
	                    <td><c:out value="${purchasedetails.gender}" /></td>
	                    <td><c:out value="${purchasedetails.size}" /></td>
	                    <td><c:out value="${purchasedetails.price}" /></td>
	                </tr>	                
	            </c:forEach>
			</table>
		</form>
	</div>
</body>
</html>
