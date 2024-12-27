package com.devil.dao.impl;

import com.devil.dao.UserDao;
import com.devil.entity.User;
import com.devil.util.JdbcUtilPtimize;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * ClassName：UserDaoImpl
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User findByUserName(String usename) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtilPtimize.getConnection();

            String sql = "select * from user where name = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usename);

            resultSet = preparedStatement.executeQuery();

            User user = null;

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Date birthday = resultSet.getDate("birthday");
                user = new User(id, name, password, email, birthday);
            }

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtilPtimize.release(connection, preparedStatement, resultSet);
        }
    }
}
