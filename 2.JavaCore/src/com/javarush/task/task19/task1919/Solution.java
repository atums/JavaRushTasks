package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    static TreeMap<String, Double> map = new TreeMap<String, Double>();

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
//        String fileName = "e:\\!.txt";

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while(reader.ready()) {
            String[] str = reader.readLine().split(" ");
//            addMethod(str[0], Double.parseDouble(str[1]));
            String key = str[0];
            double value = Double.parseDouble(str[1]);
            if(map.containsKey(key)) {
            map.put(key, map.get(key) + value);
            } else {
            map.put(key, value);
            }
            System.out.println(str[0] + Double.parseDouble(str[1]));

        }
        reader.close();
        for(Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }
//    private static void addMethod(String key, Double value) {
//
//    }
}
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Solution {
//    static TreeMap<String, Double> map = new TreeMap<>();
//
//    public static void main(String[] args) throws IOException {
//        String filename = args[0];
////        String filename = "e:\\!.txt";
//
//        BufferedReader file = new BufferedReader(new FileReader(filename));
//
//        while (file.ready()) {
//            String s = file.readLine();
//            String[] strs = s.split(" ");
//            addMap(strs[0], Double.parseDouble(strs[1]));
//        }
//
//        file.close();
//
//        //show
//        for (Map.Entry<String, Double> pair : map.entrySet()) {
//            // Хотелось как в условии задачи отформатировать, а нет валидатор думает иначе.
//            //System.out.println(String.format("%s %.2f", pair.getKey(), pair.getValue()));
//            System.out.println(pair.getKey()+" "+pair.getValue()); // - Так проходит
//        }
//    }
//
//    private static void addMap(String name, Double value) {
//        if (!map.containsKey(name))
//            map.put(name,value);
//        else
//            map.put(name, map.get(name) + value);
//    }
//}