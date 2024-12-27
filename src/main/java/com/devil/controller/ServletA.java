package com.devil.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * ClassName：ServletA
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
@WebServlet("/ServletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie user1 = new Cookie("user", "devil1");
        Cookie user2 = new Cookie("user", "devil2");
        Cookie user3 = new Cookie("user", "devil3");
        resp.addCookie(user1);
        user1.setMaxAge(60);
        resp.addCookie(user2);
        resp.addCookie(user3);
//        HttpSession session = req.getSession();
//        //获取session ID
//        String id = session.getId();
//        System.out.println(id);
//        //如果不是新创建的session
//        boolean aNew = session.isNew();
//        System.out.println(aNew);
//
//        //设置失效时间
//        session.setMaxInactiveInterval(60);
//        //将数据存到session
//        session.setAttribute("username","admin");
    }
}
