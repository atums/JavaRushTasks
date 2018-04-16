package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("F000", "I000");
        map.put("F001", "I001");
        map.put("F002", "I003");
        map.put("F003", "I003");
        map.put("F004", "I004");
        map.put("F005", "I005");
        map.put("F006", "I006");
        map.put("F008", "I007");
        map.put("F008", "I008");
        map.put("F009", "I009");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
