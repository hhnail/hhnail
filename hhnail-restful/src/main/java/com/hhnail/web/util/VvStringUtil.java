package com.hhnail.web.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VvStringUtil {

    public static void printSplitLine() {
        System.out.println("============================== 华丽的分割线 =============================");
    }



    /**
     * 比较字符串内容是否相等（防止NPE）
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean safeEquals(Object str1, Object str2) {
        if (str1 == null) {
            str1 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str1.equals(str2);
    }


    /**
     * 判断是否为空
     *
     * @param str1
     * @return
     */
    public static boolean isEmpty(Object str1) {
        return str1 == null || "".equals(str1);
    }

    /**
     * 判断是否非空
     *
     * @param str1
     * @return
     */
    public static boolean isNotEmpty(Object str1) {
        return str1 != null && !"".equals(str1);
    }


    /**
     * 使用占位符将str补到length长度的字符串
     *
     * @param length
     * @param placeholder
     * @param str
     * @return
     */
    public static String leftComplete(Integer length, String placeholder, Object str) {
        if (str != null && str.toString().length() > length) {
            throw new RuntimeException("字符串【" + str + "】长度已经超过填充长度");
        }
        StringBuffer result = new StringBuffer();
        for (Integer i = 0; i < length - ("" + str).length(); i++) {
            result.append(placeholder);
        }
        result.append(str);
        return result.toString();
    }



    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    public static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    public static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

    public static void sort(String a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    /**
     * XML格式的字符串转Map
     * @param xmlString
     * @return
     * @throws Exception
     */
    public static Map<String, Object> convertXmlToMap(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlString)));
        document.getDocumentElement().normalize();

        Map<String, Object> map = new HashMap<>();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            if (element.getChildNodes().getLength() == 1) {
                map.put(element.getNodeName(), element.getTextContent());
            } else if (element.getChildNodes().getLength() > 1) { // 说明下面有多个元素。可能是map或者list
                NodeList level2 = element.getChildNodes();
                NodeList nodeListLevel2 = element.getChildNodes();
                Map<String, Object> mapLevel2 = new HashMap<>();
                List<String> listLevel2 = new ArrayList<>();

                if (VvStringUtil.safeEquals(
                        level2.item(0).getNodeName(),
                        level2.item(1).getNodeName())
                ) {
                    for (int j = 0; j < nodeListLevel2.getLength(); j++) {
                        Element elementLevel2 = (Element) nodeListLevel2.item(j);
                        listLevel2.add(elementLevel2.getTextContent());
                    }
                    map.put(element.getNodeName(), listLevel2);
                } else {
                    for (int j = 0; j < nodeListLevel2.getLength(); j++) {
                        Element elementLevel2 = (Element) nodeListLevel2.item(j);
                        mapLevel2.put(elementLevel2.getNodeName(), elementLevel2.getTextContent());
                    }
                    map.put(element.getNodeName(), mapLevel2);
                }
            }
        }
        return map;
    }

    public static String safeGetFromMap(Map<String, Object> map, String key) throws Exception {
        if (map == null) {
            return "";
        }
        return VvStringUtil.isEmpty(map.get(key)) ? "" : map.get(key).toString();
    }



}
