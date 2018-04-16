package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/
public class Solution {
//    public static void main(String[] args) {
//        Map<String, String> param = new LinkedHashMap<>();
//        param.put("name", "Ivanov");
//        param.put("country","Ukraine");
//        param.put("city","Kiev");
//        param.put("age", null);
//        param.put("name1","Petrov");
//        param.put("name2","Sidoroff");
//
//        System.out.println(getQuery(param));
//    }
//    public static String getQuery(Map<String, String> params) {
//        StringBuilder sb = new StringBuilder();
//        int count = 0;
////        System.out.println();
//        for(Map.Entry<String, String> pair : params.entrySet()) {
//            count++;
//            if(pair.getValue() != null) {
//                sb.append(pair.getKey()).append(" = ").append("\'").append(pair.getValue()).append("\'");
//                if(count < params.size() - 1)
//                    sb.append(" and ");
//            }
//        }
//        return sb.toString();
//    }
public static void main(String[] args) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("name","Ivanov");
    map.put("country","Ukraine");
    map.put("city","Kiev");
    map.put("age",null);
    map.put("name1","Ivanov");
    map.put("name2","Ivanov");

    System.out.println(getQuery(map));
}

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        if (params == null || params.isEmpty())
            return result.toString();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null)
                continue;

            result.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
        }

        if (result.length() > 5)
            result.delete(result.length() - 5, result.length());

        return result.toString();
    }
}
