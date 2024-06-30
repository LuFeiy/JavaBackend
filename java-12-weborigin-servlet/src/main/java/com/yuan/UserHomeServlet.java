package com.yuan;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;



@WebServlet("/userHome")
public class UserHomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // 不创建新会话，只获取现有会话

        if (session != null && session.getAttribute("user") != null) {
            // 会话存在且包含用户信息，因此用户已登录
            String username = (String) session.getAttribute("user");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("</body></html>");
        } else {
            // 会话不存在或不包含用户信息，可能是会话超时或用户未登录
            response.sendRedirect("huihua/login.html"); // 重定向回登录页面
        }
    }
}
