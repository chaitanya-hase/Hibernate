<%@ page import="java.util.*,model.Order"%>

<html>
<head>
<title>My Orders</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>My Orders</h2>

<table border="1">

<tr>
    <th>Order ID</th>
    <th>Total Amount</th>
</tr>

<%
List<Order> orders = (List<Order>)request.getAttribute("orders");

if(orders != null){
    for(Order order : orders){
%>

<tr>
    <td><%=order.getOrderId()%></td>
    <td><%=order.getTotalAmount()%></td>
</tr>

<%
    }
}
%>

</table>

<br>

<a href="customerDashboard.jsp">Back</a>

</body>
</html>