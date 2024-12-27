package com.devil.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * ClassName：WebUtil
 *
 * @author: Devil
 * @Date: 2024/8/31
 * @Description:
 * @version: 1.0
 */
public class WebUtil {
    private static ObjectMapper objectMapper;

    //初始化objectMapper
    static {
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    //将Result对象转成Json字符串，并且放到响应对象中
    public static void writeJson(HttpServletResponse resp, Result result){
        resp.setContentType("application/json;charset=UTF-8");
        try {
            String json= objectMapper.writeValueAsString(result);
            resp.getWriter().write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
