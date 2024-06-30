package com.yuan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/greet1")
public class GreetServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求参数
        String username = request.getParameter("username");

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        // 获取PrintWriter对象来输出响应
        PrintWriter out = response.getWriter();

        try {
            // 输出HTML内容
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta charset='UTF-8'><title>Greeting</title></head>");
            out.println("<body>");
            out.println("<h1>Hello, " + (username != null ? username : "World") + "!</h1>");
            out.println("</body></html>");
        } finally {
            out.close(); // 关闭流
        }
    }
}
