package com.yuan;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;


@WebServlet(name = "Lifecycle", value = "/life")
public class LifecycleServlet extends HttpServlet {

    public void init() throws ServletException {
        // 初始化代码，比如资源的配置
        System.out.println("Servlet init() called");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 处理请求的核心方法
        System.out.println("Servlet service() called");

        // 响应客户端
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        out.println("Hello, your request is being processed.");
    }

    public void destroy() {
        // 清理资源
        System.out.println("Servlet destroy() called");
    }
}
