package com.yuan;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 假设我们已经验证了用户的用户名和密码
        boolean isValidUser = checkUser(request.getParameter("username"), request.getParameter("password"));

        if (isValidUser) {
            // 用户验证成功，创建或获取会话
            HttpSession session = request.getSession();
            session.setAttribute("user", request.getParameter("username"));
            // 可以设置会话超时时间
            session.setMaxInactiveInterval(30*60); // 30分钟
            // 重定向到用户主页
            response.sendRedirect("userHome");
        } else {
            // 用户验证失败
            response.sendRedirect("loginError");
        }
    }

    private boolean checkUser(String username, String password) {
        // 这里应该是一些验证逻辑，现在只是为了演示
        return "admin".equals(username) && "password123".equals(password);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "message" + "</h1>");
        out.println("</body></html>");
    }
}
