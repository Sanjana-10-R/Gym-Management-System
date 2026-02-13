<%@ page import="com.wipro.gym.bean.GymBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Member Record</title></head>
<body>

<h2>Member Record</h2>

<%
    GymBean bean = (GymBean) request.getAttribute("member");
    String message = (String) request.getAttribute("message");

    if (bean != null) {
%>
--------------------------------------<br>
Record ID: <%= bean.getRecordId() %><br>
Member Name: <%= bean.getMemberName() %><br>
Membership Type: <%= bean.getMembershipType() %><br>
Joining Date: <%= bean.getJoiningDate() %><br>
Duration Months: <%= bean.getDurationMonths() %><br>
Fees: <%= bean.getFees() %><br>
Remarks: <%= bean.getRemarks() %><br>
--------------------------------------<br>

<%  } else { %>

<h3><%= message %></h3>

<%  } %>

<br><a href="menu.html">Back to Menu</a>

</body>
</html>
