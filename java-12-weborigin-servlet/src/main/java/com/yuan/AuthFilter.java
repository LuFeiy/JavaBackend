package com.yuan;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/form")
public class AuthFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
        // 过滤器初始化代码，通常用于资源的加载或初始化配置参数
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("user") != null;

        if (loggedIn) {
            // 用户已登录，继续过滤链
            System.out.println("用户已登录, 正常访问");
            chain.doFilter(request, response);
        } else {
            // 用户未登录，重定向到登录页面
            System.out.println("用户未登录, 重定向到登录页面");
            res.sendRedirect(req.getContextPath() + "/huihua/login.html");
        }
    }

    public void destroy() {
        // 过滤器销毁时的清理代码
    }
}
