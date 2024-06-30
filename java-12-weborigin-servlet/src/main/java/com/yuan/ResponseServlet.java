package com.yuan;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/response-info")
public class ResponseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置内容类型为HTML
        response.setContentType("text/html;charset=UTF-8");

        // 获取PrintWriter对象来发送响应体
        PrintWriter out = response.getWriter();

        try {
            // 设置状态码为200 OK
            response.setStatus(HttpServletResponse.SC_OK);

            // 输出HTML内容
            out.println("<html><body>");
            out.println("<h1>Welcome to Servlet Response Example</h1>");
            out.println("</body></html>");
        } finally {
            out.close(); // 确保PrintWriter被关闭
        }
    }
}
