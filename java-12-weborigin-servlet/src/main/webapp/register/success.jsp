<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 2024/5/18
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String username = request.getParameter("username");
%>
<html>
<head>
  <title>Registration Successful</title>
</head>
<body>
<h2>Registration Successful</h2>
<% if (username != null && !username.trim().isEmpty()) { %>
<p>Welcome, <%= username %>! Thank you for registering with us.</p>
<% } else { %>
<p>Error: No username provided.</p>
<% } %>
</body>
</html>
