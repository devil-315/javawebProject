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
@WebServlet("/areaA")
public class TestAreaA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求域
        req.setAttribute("Request","Request-message");

        //会话域
        HttpSession session = req.getSession();
        session.setAttribute("session","session-message");

        //应用域
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("application","application-message");
    }
}
