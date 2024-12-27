package com.devil.dao;

import com.devil.entity.User;

/**
 * ClassName：UserDao
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
//TODO 数据库接口层
public interface UserDao {

    //查询 用户名
    User findByUserName(String usename);

}
