package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("000", 300);
        map.put("111", 500);
        map.put("222", 100);
        map.put("333", 1000);
        map.put("444", 6000);
        map.put("555", 350);
        map.put("666", 110);
        map.put("777", 4000);
        map.put("888", 20000);
        map.put("999", 10000);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            int value = pair.getValue();
            if(value < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {


    }
}