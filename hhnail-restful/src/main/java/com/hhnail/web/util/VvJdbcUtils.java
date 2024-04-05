package com.hhnail.web.util;



import com.hhnail.web.mapper.ResultSetMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VvJdbcUtils {

    // hive2
    private static String jdbcDriverName = "org.apache.hive.jdbc.HiveDriver";

    public static <T> List<T> executeQuery(String url, String user, String password, String sql, ResultSetMapper<T> mapper) {
        List<T> results = new ArrayList<>();  
        Connection conn = null;  
        PreparedStatement stmt = null;  
        ResultSet rs = null;
  
        try {  
            Class.forName(jdbcDriverName); // 假设我们使用MySQL，需要加载相应的驱动
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
}