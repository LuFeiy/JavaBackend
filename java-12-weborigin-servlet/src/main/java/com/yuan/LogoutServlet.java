package com.yuan;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // 不创建新会话，只获取现有会话
        if (session != null) {
            session.invalidate(); // 终止会话
        }
        response.sendRedirect("huihua/login.html"); // 重定向回登录页面
    }
}
