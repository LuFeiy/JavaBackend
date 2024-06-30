package com.yuan;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet(name = "Simple", value = "/simple")
public class SimpleServlet extends HttpServlet {

    // 初始化方法，可以获取ServletConfig对象
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 从config获取初始化参数
        String initParameter = config.getInitParameter("exampleInitParam");
        // 你可以在这里执行一些基于初始化参数的操作
    }

    // 处理GET请求的方法
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应内容类型
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 创建HTML响应内容
        out.println("<html>");
        out.println("<head><title>Simple Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    // 销毁方法，可以释放资源
    public void destroy() {
        // 你可以在这里释放资源，比如关闭数据库连接
    }
}
