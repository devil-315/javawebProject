package com.devil.controller;

import com.devil.emun.ResultEnum;
import com.devil.util.Result;
import com.devil.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName：CheckUserName
 *
 * @author: Devil
 * @Date: 2024/8/30
 * @Description:
 * @version: 1.0
 */
@WebServlet("/checkUserName")
public class CheckUserName extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端传递过来的数据
        String username = req.getParameter("username");
        //封装的结果对象
        Result result =null;
        if(username.equals("admin1")){
            result = Result.build(null, ResultEnum.SUCCESS);
        }else {
            result = Result.build(null,500,"error");
        }
        WebUtil.writeJson(resp,result);
    }
}
