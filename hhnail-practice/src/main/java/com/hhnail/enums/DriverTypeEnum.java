package com.hhnail.enums;

/**
 * 数据库驱动类型
 */
public enum DriverTypeEnum {

    MYSQL_DRIVER("com.mysql.cj.jdbc.Driver");

    private String driverType;

    private DriverTypeEnum(String driverType) {
        this.driverType = driverType;
    }

    public String getName() {
        return this.driverType;
    }
}
