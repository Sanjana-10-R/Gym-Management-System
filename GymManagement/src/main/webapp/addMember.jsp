<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Add Member</title></head>
<body>

<h2>Add Member Record</h2>

<form action="MainServlet" method="post">
    <input type="hidden" name="operation" value="newRecord">

    Member Name:<br>
    <input type="text" name="memberName" required><br><br>

    Membership Type:<br>
    <input type="text" name="membershipType" required><br><br>

    Joining Date:<br>
    <input type="date" name="joiningDate" required><br><br>

    Duration Months:<br>
    <input type="number" name="durationMonths" required><br><br>

    Fees:<br>
    <input type="number" name="fees" required><br><br>

    Remarks:<br>
    <input type="text" name="remarks"><br><br>

    <input type="submit" value="Add Member">
</form>

<a href="menu.html">Back to Menu</a>

</body>
</html>
