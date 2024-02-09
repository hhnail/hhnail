package com.hhnail.web.util;

import com.hhnail.enums.DriverTypeEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String ORACLE_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     */
    Connection getConnection(DriverTypeEnum driverType, String url, String user, String password) {
        try {
            Class.forName(driverType.getName());
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            System.out.println("SQL异常");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载异常");
            e.printStackTrace();
        }
        return null;
    }
}
