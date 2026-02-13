<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>View Member</title></head>
<body>

<h2>View Member Record</h2>

<form action="MainServlet" method="post">
    <input type="hidden" name="operation" value="viewRecord">

    Member Name:<br>
    <input type="text" name="memberName" required><br><br>

    Joining Date:<br>
    <input type="date" name="joiningDate" required><br><br>

    <input type="submit" value="View Record">
</form>

<a href="menu.html">Back to Menu</a>

</body>
</html>
