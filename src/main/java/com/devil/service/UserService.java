package com.devil.service;

import com.devil.entity.User;

/**
 * ClassName：UserService
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
//TODO 业务处理层
public interface UserService {
    //登录
    User login(String username,String password);
}
