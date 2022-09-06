package com.hhnail.test;

import lombok.Data;

public class NullTest {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.getSuccess() == null);
        // System.out.println(demo.getSuccess() == false);
    }
}

@Data
class Demo{
    private Boolean success;
}
