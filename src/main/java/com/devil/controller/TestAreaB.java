package com.devil.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName：TestAreaA
 *
 * @author: Devil
 * @Date: 2024/8/30
 * @Description:
 * @version: 1.0
 */
@WebServlet("/areaB")
public class TestAreaB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求域的数据
        Object request = req.getAttribute("Request");
        resp.getWriter().print(request);

        //获取会话域的数据
        HttpSession session = req.getSession();
        Object session1 = session.getAttribute("session");
        resp.getWriter().print(session1);

        //获取应用域的数据
        ServletContext servletContext = getServletContext();
        Object application = servletContext.getAttribute("application");
        resp.getWriter().print(application);
    }
}
