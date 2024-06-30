<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 2024/5/18
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%
    // 初始化变量
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    boolean isRegistered = false;
    String registrationMessage = "";

    // 检查是否从表单接收到数据
    if (username != null && password != null && email != null) {
        // 这里应该是连接数据库并将用户信息存储起来的代码
        // 为了简单起见，我们假设用户已经成功注册
        // 实际应用中，您需要添加真实的数据库操作代码
        // 以下代码仅为示例，不应在生产环境中使用
        registrationMessage = "Registration Successful. Welcome, " + username + "!";
        isRegistered = true;
    }
%>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<% if (!isRegistered) { %>
<!-- 如果用户尚未注册（表单尚未提交），则显示注册表单 -->
<h2>User Registration Form</h2>
<form action="register.jsp" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>

    <input type="submit" value="Register">
</form>
<% } else { %>
<!-- 如果用户已注册（表单已提交），则显示成功消息 -->
<h2><%= registrationMessage %></h2>
<% } %>
</body>
</html>
