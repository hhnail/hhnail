package com.hhnail.util;

public class ByteUtil {

    public static void main(String[] args) {
        System.out.println(parseByteValue2IntValue(111));
    }


    public static Integer parseByteValue2IntValue(Integer value){
        Double result = 0d;
        String[] chars = value.toString().split("");
        for (int i = 0; i < chars.length; i++) {
            double temp = Math.pow(Double.parseDouble(chars[i]), Double.parseDouble(i + ""));
            result += temp;

        }
        return result.intValue();
    }

}
