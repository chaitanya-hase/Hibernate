<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Food</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Add Food Item</h2>

<form action="AddFoodServlet" method="post">

    Name: <input type="text" name="name" required /> <br><br>

    Price: <input type="text" name="price" required /> <br><br>

    <input type="submit" value="Add Food" />

</form>

</body>
</html>