package com.hhnail.test;

import com.hhnail.util.VStringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author r221587
 * @version 1.0
 * @description: TODO
 * @date 2023/5/25 14:18
 */
public class ParamTest {

    public static void main(String[] args) {
        ParamTest test = new ParamTest();
        String str = "str111";
        System.out.println(str);
        test.changeQuote(str);
        System.out.println(str);


        VStringUtil.printSplitLine();

        Map<String, Object> map = new HashMap<>();
        map.put("k2", "ewwfwf112222");
        System.out.println(map);
        test.changeQuote4MapTest(map);
        System.out.println(map);

        VStringUtil.printSplitLine();

        Map<String, Object> map2 = new HashMap<>();
        map2.put("k2", "ewwfwf112222");
        System.out.println(map2);
        test.changeQuote4MapTest2(map2);
        System.out.println(map2);

        VStringUtil.printSplitLine();

        int i = 666;
        System.out.println(i);
        test.changeQuote4Int(i);
        System.out.println(i);

    }


    private void changeQuote(String str) {
        str = "str222";
    }


    private void changeQuote4MapTest(Map<String, Object> map) {
        map = new HashMap<String, Object>() {{
            put("k1", "fwefwefwfwff");
        }};
    }

    private void changeQuote4MapTest2(Map<String, Object> map) {
        map.put("k1", "fwefwefwfwff");
    }

    private void changeQuote4Int(int i) {
        i = 555;
    }

}