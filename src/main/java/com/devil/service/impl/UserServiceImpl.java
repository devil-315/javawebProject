package com.devil.service.impl;

import com.devil.dao.UserDao;
import com.devil.dao.impl.UserDaoImpl;
import com.devil.entity.User;
import com.devil.service.UserService;

/**
 * ClassName：UserServiceImpl
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username,String password) {
        //只要用户名正确，就能返回
        User user = userDao.findByUserName(username);

        if(user == null){
            return null;
        }
        //校验密码
        if(password.equals(user.getPassword())){
            return user;
        }
        return null;
    }
}
