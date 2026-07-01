<%@ page import="java.util.*, model.Food" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Food List</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<h2>Food Items</h2>

<table border="1">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Category</th>
    <th>Edit</th>
    <th>Delete</th>
</tr>

<%
List<Food> foods = (List<Food>) request.getAttribute("foods");

for(Food f : foods){
%>

<tr>

    <td><%=f.getId()%></td>

    <td><%=f.getName()%></td>

    <td><%=f.getPrice()%></td>

    <td><%=f.getCategory()%></td>

    <td>
        <a href="EditFoodServlet?id=<%=f.getId()%>">Edit</a>
    </td>

    <td>
        <a href="DeleteFoodServlet?id=<%=f.getId()%>">Delete</a>
    </td>

</tr>

<%
}
%>

</table>

<br><br>

<a href="adminDashboard.jsp">Back to Dashboard</a>

</body>
</html>