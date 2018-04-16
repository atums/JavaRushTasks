package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Stallone1", new Date("MAY 11 1981"));
        map.put("Stallone2", new Date("MAY 11 1981"));
        map.put("Stallone3", new Date("MAY 11 1981"));
        map.put("Stallone4", new Date("MAY 11 1981"));
        map.put("Stallone5", new Date("MAY 11 1981"));
        map.put("Stallone6", new Date("MAY 11 1981"));
        map.put("Stallone7", new Date("MAY 11 1981"));
        map.put("Stallone8", new Date("MAY 11 1981"));
        map.put("Stallone9", new Date("MAY 11 1981"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) iterator.next();
            Date data = (Date) pair.getValue();
            if(data.getMonth() > 4 && data.getMonth() < 8) {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {

    }
}
