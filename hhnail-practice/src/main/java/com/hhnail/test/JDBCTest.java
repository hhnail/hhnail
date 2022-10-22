package com.hhnail.test;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.sql.*;

public class JDBCTest {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/hhnail";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            String sql;
            // sql = "SELECT api_id, name, c_time FROM api";
            // stmt = conn.createStatement();
            // ResultSet rs = stmt.executeQuery(sql);
            sql = "SELECT api_id, name, c_time FROM api where 1=1" +
                    " and api_id > ?" +
                    " and name != ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "(select 1)");
            // preparedStatement.setString(1, "0");
            preparedStatement.setString(2, "1");
            ResultSet rs = preparedStatement.executeQuery();
            //STEP 5: Extract data from result set
            while (rs.next()) {
                int api_id = rs.getInt("api_id");
                String name = rs.getString("name");
                Date c_time = rs.getDate("c_time");
                System.out.println(
                        String.format("id = %d name = %s c_time = %s", api_id, name, c_time)
                );
            }
            rs.close();
            if (stmt != null) {
                stmt.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
