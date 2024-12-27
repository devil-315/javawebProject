package com.devil.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * ClassName：ServletB
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
@WebServlet("/ServletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies!=null&&cookies.length !=0){
            System.out.println(cookies.length);
            for (Cookie cookie :
                    cookies) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }

//        // 获取session对象
//        HttpSession session = req.getSession();
//        // 获取Session的ID
//        String jSessionId = session.getId();
//        System.out.println(jSessionId);
//
//        String username =(String) session.getAttribute("username");
//        System.out.println(username);
//        System.out.println("==========");
////        失效
//        session.invalidate();
//        HttpSession session1 = req.getSession();
//        String username1 = (String) session1.getAttribute("username");
//        System.out.println(username1);
    }
}
