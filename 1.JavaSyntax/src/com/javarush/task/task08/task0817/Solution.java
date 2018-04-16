package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Фамилия", "Имя0");
        for(int i = 0; i < 9; i++) {
            map.put("Фамилия" + i, "Имя" + i);
        }
        System.out.println("Заполняем" + map);
        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        //Копируем переданную мапу 2 раза
        HashMap<String, String> map2 = new HashMap(map);
        HashMap<String, String> map3 = new HashMap(map);

        //цикл по map2
        for (Map.Entry<String, String> pair : map2.entrySet())
        {
            //удаляем из map3 пару, которая соответствует pair
            System.out.println("Удаляемая пара в 1 методе из map3 = " + pair.getKey());
            map3.remove(pair.getKey());
            System.out.println("Map2 = " + map2);
            System.out.println("Map3 = " + map3);

            //проверяем на наличе  в map3 значений соответсвующего значению из pair
            if (map3.containsValue(pair.getValue())) {
                String value =  pair.getValue();
                System.out.println("Совпадение = " + value);
                //Если есть такие же значения - вызываем удаления текующего значения pair из переданной map
                System.out.println("Map2 = " + map2);
                System.out.println("Map3 = " + map3);
                removeItemFromMapByValue(map, value);
            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                System.out.println("Удаляемая пара в 2 методе = " + pair.getKey());
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.removeTheFirstNameDuplicates(createMap());


    }
}
