<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sporty Shoes</title>

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
</head>
<body>
	<h1>Welcome to Sporty Shoes</h1>
		<div align="left">
			<a href="/adminpage">Back to Admin Page</a>
		</div>
	<div align="center">
		<h2>Add New Product Information</h2>
	</div>
	<div align="center">
		<form action="addNewProduct" method="post">
			<table border="1" cellpadding="5">
				<tr>
					<th>Brand Name:</th>
					<td>
						<input type="text" name="brandname" size="45"/>
					</td>
				</tr>
				<tr>
					<th>Category:</th>
					<td>
						<input type="text" name="gender" size="45"/>
					</td>
				</tr>
				<tr>
					<th>Size:</th>
					<td>
						<input type="number" name="size" size="45"/>
					</td>
				</tr>
				<tr>
					<th>Price:</th>
					<td>
						<input type="number" name="price" size="45"/>
					</td>
				</tr>
				<tr>
					<th></th>
					<td colspan="2" align="center">
						<input type="submit" value="Add Product" />
					</td>
				</tr>
			</table>			
		</form>
	</div>
</body>
</html>
