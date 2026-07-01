<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<form action="OrderServlet" method="post">

Food ID

<input type="text"
name="foodId"
value="<%=request.getParameter("id")%>"
readonly>

Price

<input type="text"
name="price"
value="<%=request.getParameter("price")%>"
readonly>

Quantity

<input type="number"
name="quantity">

<input type="submit"
value="Place Order">

</form>
</body>
</html>