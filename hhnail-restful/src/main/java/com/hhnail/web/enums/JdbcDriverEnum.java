package com.hhnail.web.enums;

/**
 * @author phv
 * @version 1.0
 * @description: DB驱动
 */
public enum JdbcDriverEnum {

    HIVE("org.apache.hive.jdbc.HiveDriver", "hive"),
    MYSQL("com.mysql.cj.jdbc.Driver", "MySQL"),
    ;
    private String code;
    private String name;

    JdbcDriverEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
