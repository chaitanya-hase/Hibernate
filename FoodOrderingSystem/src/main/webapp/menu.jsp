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
<%@ page import="java.util.*" %>
<%@ page import="model.Food" %>

<%
List<Food> foods=(List<Food>)request.getAttribute("foods");
%>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Category</th>
<th>Action</th>
</tr>

<%
for(Food f:foods){
%>

<tr>

<td><%=f.getId()%></td>

<td><%=f.getName()%></td>

<td><%=f.getPrice()%></td>

<td><%=f.getCategory()%></td>

<td>

<a href="order.jsp?id=<%=f.getId()%>&price=<%=f.getPrice()%>">
Order
</a>

</td>

</tr>

<%
}
%>

</table>
</body>
</html>