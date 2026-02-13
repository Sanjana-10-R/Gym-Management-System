<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View All Members</title>
</head>
<body>

<h2>All Member Records</h2>

<form action="MainServlet" method="post">
    <input type="hidden" name="operation" value="viewAllRecords">
    <input type="submit" value="View All Records">
</form>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
