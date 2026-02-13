<%@ page import="java.util.List" %>
<%@ page import="com.wipro.gym.bean.GymBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>All Members</title></head>
<body>

<h2>All Member Records</h2>

<%
    List<GymBean> list = (List<GymBean>) request.getAttribute("gymList");
    String message = (String) request.getAttribute("message");

    if (list != null && !list.isEmpty()) {
        for (GymBean bean : list) {
%>
--------------------------------------<br>
Record ID: <%= bean.getRecordId() %><br>
Member Name: <%= bean.getMemberName() %><br>
Membership Type: <%= bean.getMembershipType() %><br>
Joining Date: <%= bean.getJoiningDate() %><br>
Duration Months: <%= bean.getDurationMonths() %><br>
Fees: <%= bean.getFees() %><br>
Remarks: <%= bean.getRemarks() %><br>
--------------------------------------<br><br>
<%      }
    } else {
%>
<h3><%= message %></h3>
<%  } %>

<br><a href="menu.html">Back to Menu</a>

</body>
</html>
s