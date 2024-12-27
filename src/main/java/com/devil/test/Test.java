package com.devil.test;

import com.devil.util.JdbcUtilPtimize;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * ClassName：Test
 *
 * @author: Devil
 * @Date: 2024/8/29
 * @Description:
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUtilPtimize.getConnection();
        System.out.println(connection);
    }
}
