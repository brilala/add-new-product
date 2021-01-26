<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter product details below: </title>
</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/AddProduct">
Product:<br>
<input type="text" name="product">
<br>
Quantity:<br>
<input type="text" name="quantity">
<br><br>
<input type="submit" value="submit">
</form>

</body>
</html>