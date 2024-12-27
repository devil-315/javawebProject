package com.devil.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName：LoginFilter
 *
 * @author: Devil
 * @Date: 2024/8/30
 * @Description:
 * @version: 1.0
 */
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //servletRequest ==>HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        Object username = req.getSession().getAttribute("username");
        //如果username不为空，就是登录了，直接放行
        if (username != null) {
            filterChain.doFilter(req, resp);
            return;
        }

        String path = req.getRequestURI();
        //登录，退出放行
        if (path.contains("/user") || path.contains("/js/jquery-1.7.2.js")) {
            filterChain.doFilter(req, resp);
            return;
        }
        if(path.contains("/checkUserName")){
            filterChain.doFilter(req, resp);
            return;
        }

        if(path.contains("/LoginUserError.html")){
            filterChain.doFilter(req, resp);
            return;
        }

        if (path.equals("/") || path.equals("/index.html")) {
            //获取cookie，如果有对应的cookie，说明登录过，直接进入主页面
            //创建cookie数组
            Cookie[] cookies = req.getCookies();
            if (cookies.length > 0 && cookies != null) {
                //遍历cookie数组
                for (Cookie cookie : cookies) {
                    System.out.println(cookie.getName() + "====>" + cookie.getValue());
                    if ("user".equals(cookie.getName())) {
                        //只要找到对应的cookie，直接登录
                        req.getRequestDispatcher("/sys/show.html").forward(req, resp);
                        return;
                    }
                }
            }
            filterChain.doFilter(req, resp);
            return;
        }

        //如果没登录回到主页面
        resp.sendRedirect("/index.html");
    }
}
