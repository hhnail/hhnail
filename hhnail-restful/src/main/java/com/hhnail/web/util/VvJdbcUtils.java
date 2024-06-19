package com.hhnail.web.util;


import com.hhnail.web.enums.JdbcDriverEnum;
import com.hhnail.web.mapper.ResultSetMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VvJdbcUtils {

    // hive2
    // private static String jdbcDriverName = "org.apache.hive.jdbc.HiveDriver";

    public static <T> List<T> executeQuery(
            JdbcDriverEnum jdbcDriverName,
            String url,
            String user,
            String password,
            String sql, ResultSetMapper<T> mapper
    ) {
        List<T> results = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName(jdbcDriverName.getCode());
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(mapper.mapRow(rs));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    // 获取数据库连接
    public static Connection getConnection(
            JdbcDriverEnum jdbcDriverName,
            String url,
            String user,
            String password
    ) {
        Connection conn = null;
        try {
            Class.forName(jdbcDriverName.getCode()); // MySQL驱动类名
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 执行更新操作（包括插入和删除）
    public static int executeUpdate(
            JdbcDriverEnum jdbcDriverName,
            String url,
            String user,
            String password,
            String sql
    ) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection(jdbcDriverName, url, user, password);
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1; // 表示操作失败
    }
}