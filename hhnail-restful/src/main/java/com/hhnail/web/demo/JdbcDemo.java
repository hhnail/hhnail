package com.hhnail.web.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

/**
 * @author phv
 * @description: JDBC案例
 */
public class JdbcDemo {


    private static String jdbcDriverName = "org.apache.hive.jdbc.HiveDriver";
    private static String jdbcUrl = "jdbc:hive2://IP:端口";
    private static String jdbcUser = "root";
    private static String jdbcPwd = "root";

    public static void main(String[] args) throws Exception {
        new JdbcDemo().getEvent();
    }

    @PostMapping("/getEvent")
    public Map<String, Object> getEvent() throws Exception {
        Statement stmt = null;
        Connection con = null;
        try {
            Class.forName(jdbcDriverName);
            con = DriverManager.getConnection(
                    jdbcUrl, jdbcUser, jdbcPwd
            );
            stmt = con.createStatement();
            String sql = "SELECT user_id,distinct_id,event,time,$lib as lib  FROM events "
                    + "WHERE `date` = CURRENT_DATE() LIMIT 10 /*SA*/;";
            // String sql = "SELECT EMPLOYEE_NO, EMPLOYEE_NAME FROM BAS_EMPLOYEE ";

            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                System.out.println(
                        res.getString(1)
                                // + "\t" + res.getString(2)
                );
            }

            return null;
        } catch (Exception e) {
            // log.info("===" + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            stmt.close();
            con.close();
        }
    }
}
