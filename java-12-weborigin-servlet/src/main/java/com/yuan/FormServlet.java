package com.yuan;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet(name = "Form", value = "/form")
public class FormServlet extends HttpServlet {

    // 处理GET请求的doGet方法
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应内容类型为HTML
        response.setContentType("text/html;charset=UTF-8");

        // 获取响应的输出流
        PrintWriter out = response.getWriter();

        // 输出HTML表单
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Form Submission</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Please fill out this form:</h2>");
        out.println("<form action='form' method='POST'>");  // POST请求的目标URL是FormServlet
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Email: <input type='text' name='email'><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    // 处理POST请求的doPost方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 设置响应内容类型为HTML
        response.setContentType("text/html;charset=UTF-8");

        // 获取请求参数
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // 获取响应的输出流
        PrintWriter out = response.getWriter();

        // 输出处理结果
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Form Submission Result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Form Submission Details</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
