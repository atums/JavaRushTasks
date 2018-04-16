package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        for(int i = 0; i < 10; i++) {
            map.put("Name" + i, "LastName" + i);
        }
//        map.put()
        return map;

    }


    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;

        for (HashMap.Entry b : map.entrySet()) {
            String c = (String) b.getValue();
            if (c.equals(name)) {
                count++;
            }

        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;

        for (HashMap.Entry b : map.entrySet()) {
            String c = (String) b.getKey();
            if (c.equals(lastName)) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {

    }
}
