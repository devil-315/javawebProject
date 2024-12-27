package com.devil.test;

import com.devil.dao.impl.UserDaoImpl;
import com.devil.entity.User;

/**
 * ClassName：TestUser
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
public class TestUser {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User admin1 = userDao.findByUserName("admin1");
        System.out.println(admin1);
    }
}
