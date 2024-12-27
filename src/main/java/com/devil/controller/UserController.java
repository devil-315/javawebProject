package com.devil.controller;

import com.devil.entity.User;
import com.devil.service.UserService;
import com.devil.service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * ClassName：UserController
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端请求项目中的具体资源
        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];
        if(methodName.equals("login")){
            login(req,resp);
        }else if(methodName.equals("logout")){
            logout(req,resp);
        }
    }

    //登录
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //响应乱码的问题
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        //获取客户端传过来的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.login(username,password);
        if(user != null){

            //创建cookie对象
            Cookie cookie = new Cookie("user", username);
            //设置cookie的持久化时间
            cookie.setMaxAge(60);
            //TODO 在 "/" 下的所有请求都能获取到cookie
            cookie.setPath("/");
            resp.addCookie(cookie);

            //登录成功，添加会话
            HttpSession session = req.getSession();
            session.setAttribute("username",session.getId());

            //TODO 重定向 请求地址栏发生变化
            resp.sendRedirect("/sys/show.html");
        }else {
            //TODO 请求转发：请求地址栏不变
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/LoginUserError.html");
            requestDispatcher.forward(req,resp);
        }
    }

    //退出
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object username = req.getSession().getAttribute("username");
        if(username != null){
            //消失
            req.getSession().invalidate();
        }
        resp.sendRedirect("/index.html");
    }
}
