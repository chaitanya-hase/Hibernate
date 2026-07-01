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
<%@ page import="model.Food" %>

<%
    Food f = (Food) request.getAttribute("food");
%>

<h2>Edit Food</h2>

<form action="UpdateFoodServlet" method="post">

    <input type="hidden" name="id" value="<%= f.getId() %>" />

    Name:
    <input type="text" name="name" value="<%= f.getName() %>" /> <br><br>

    Price:
    <input type="text" name="price" value="<%= f.getPrice() %>" /> <br><br>

    <input type="submit" value="Update" />

</form>
</body>
</html>