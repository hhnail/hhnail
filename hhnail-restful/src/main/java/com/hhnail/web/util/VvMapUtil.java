package com.hhnail.web.util;

import java.util.Map;

/**
 * @author 221587
 * @version 1.0
 * @description: Map工具类
 * @date 2024/3/1 10:05
 */
public class VvMapUtil {

    public static String safeGetString(Map<String, Object> map, String key){
        if (map == null) {
            return "";
        }
        return VvStringUtil.isEmpty(map.get(key)) ? "" : map.get(key).toString();
    }

    public static Integer safeGetInteger(Map<String, Object> map, String key) {
        if (map == null) {
            return null;
        }
        try {
            return Integer.parseInt(map.get(key).toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            // throw new RuntimeException("转化Integer失败");
        }
    }

    public static Long safeGetLong(Map<String, Object> map, String key) {
        if (map == null) {
            return null;
        }
        try {
            return Long.parseLong(map.get(key).toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            // throw new RuntimeException("转化Integer失败");
        }
    }


}
