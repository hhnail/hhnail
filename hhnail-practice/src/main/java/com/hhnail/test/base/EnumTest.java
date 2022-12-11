package com.hhnail.test.base;

public class EnumTest {

    public static void main(String[] args) {
        MyEnum[] values = MyEnum.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].getType());

        }
    }
}


enum MyEnum {
    SHOP("4"),
    GUIDE("5");

    // 类型。4代表门店、5代表导购
    private String type;
    // 如果type是4——>门店编号、5——>导购编号
    private String setTypeA;
    // 如果type是4——>门店名称、5——>导购名称
    private String setTypeB;

    MyEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}