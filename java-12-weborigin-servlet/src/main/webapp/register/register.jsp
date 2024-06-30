<%--
  Created by IntelliJ IDEA.
  User: yuan
  Date: 2024/5/18
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.URLEncoder" %>
<%
  // 初始化变量
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  String email = request.getParameter("email");

  // 在实际应用中，这里应该是连接数据库并将用户信息存储起来的代码
  // 以下代码仅为示例，不应在生产环境中使用
  // 假设注册总是成功
  if (username != null && !username.trim().isEmpty()) {
    // 注册逻辑（假设总是成功）
    // 注册后重定向到注册成功页面
    response.sendRedirect("success.jsp?username=" + URLEncoder.encode(username, "UTF-8"));
    return;
  }
%>

<!-- 如果注册信息不完整，可以添加错误处理逻辑，或者重新定向回注册表单 -->
