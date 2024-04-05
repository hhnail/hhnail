package com.hhnail.web.util;

import java.util.regex.Pattern;

/**
 * @author r221587
 * @version 1.0
 * @description: 正则表达式工具
 * @date 2023/7/15 15:58
 */
public class VvRegExpUtil {

    /**
     * 手机号正则
     * 第一位必须是1；
     *  第二位如果是3，第三可以0~9
     *  第二位如果是4，第三可以是01456879
     *  第二位如果是5，第三可以是0~3或5~9
     *  以此类推
     */
    private static final Pattern MOBILE_NUMBER_PATTERN = Pattern.compile("^1(3[0-9]|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\\d{8}$");

    /**
     * 座机正则
     */
    private static final Pattern LANDLINE_PATTERN = Pattern.compile("^(0\\d{2,3})-?(\\d{7,8})$");

    /**
     * 邮箱正则
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(0\\d{2,3})-?(\\d{7,8})$");


    /**
     * 是否是有效手机号
     * @param mobile
     * @return
     */
    public static boolean isValidMobileNumber(String mobile) {
        return MOBILE_NUMBER_PATTERN.matcher(mobile).matches();
    }

    public static void main(String[] args) {
        String mobileNumber = "13812345678"; // 示例手机号码
        boolean isValid = isValidMobileNumber(mobileNumber);
        System.out.println("手机号是否合法13812345678: " + isValid);
        System.out.println("手机号是否合法14130290509: " + isValidMobileNumber("14130290509"));
        System.out.println("手机号是否合法14230290509: " + isValidMobileNumber("14230290509"));
        System.out.println("手机号是否合法15030290509: " + isValidMobileNumber("15030290509"));
        System.out.println("手机号是否合法15430290509: " + isValidMobileNumber("15430290509"));
        System.out.println("手机号是否合法18030290509: " + isValidMobileNumber("18030290509"));



    }

}
