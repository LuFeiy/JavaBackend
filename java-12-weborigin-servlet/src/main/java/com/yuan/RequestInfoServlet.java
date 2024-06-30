package com.yuan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Enumeration;

@WebServlet("/request-info")
public class RequestInfoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        // 获取PrintWriter对象来输出响应
        PrintWriter out = response.getWriter();

        try {
            // 输出HTML内容
            out.println("<html><head><title>Request Information Example</title></head><body>");
            out.println("<h2>Request Information:</h2>");

            // 获取客户端IP地址
            out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");

            // 获取请求的HTTP方法
            out.println("<p>HTTP Method: " + request.getMethod() + "</p>");

            // 获取请求的完整URL
            StringBuffer requestURL = request.getRequestURL();
            out.println("<p>Request URL: " + requestURL.toString() + "</p>");

            // 获取请求的URI
            String requestURI = request.getRequestURI();
            out.println("<p>Request URI: " + requestURI + "</p>");

            // 获取所有的请求头名称
            out.println("<p>Request Headers:</p>");
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                out.println("<b>" + headerName + "</b>: ");

                // 获取请求头的值（可以是多个值）
                Enumeration<String> headers = request.getHeaders(headerName);
                while (headers.hasMoreElements()) {
                    String headerValue = headers.nextElement();
                    out.println(headerValue);
                    if (headers.hasMoreElements()) {
                        out.println(", ");
                    }
                }
                out.println("<br>");
            }

            out.println("</body></html>");
        } finally {
            out.close(); // 关闭流
        }
    }
}
