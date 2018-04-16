package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Solution {
//    static TreeMap<String, Double> map = new TreeMap<String, Double>();
//    static double maxSalary = 0;
//    public static void main(String[] args) throws Exception {
//        String file = args[0];
////        String file = "e:\\!.txt";
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//
//        while(reader.ready()) {
//            String s = reader.readLine();
//            String[] str = s.split(" ");
//            String name = str[0];
//            double salary;
//            try {
//                salary = Double.parseDouble(str[1]);
//            }catch(ArrayIndexOutOfBoundsException ex) {
//                continue;
//            }
//            if(salary > maxSalary) {
//                maxSalary = salary;
//            }
//            if(map.containsKey(name)) {
//                map.put(name, map.get(name) + salary);
//            } else {
//                map.put(name, salary);
//            }
//        }
//        reader.close();
//
//        for(Map.Entry<String, Double> pair : map.entrySet()) {
////            if(maxSalary == pair.getValue()) {
////                System.out.println(pair.getKey());
////            }
//            int result = pair.getValue().compareTo(maxSalary);
//            if(result == 0) {
//                System.out.println(pair.getKey());
//            }
//        }
//    }
//}

// Ну это чушь, мое решение работает!!! Сраный валидатор.
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        double max = Double.MIN_VALUE;
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] strs = s.split("[\\s\\t\\n\\x0B\\f\\r]");
            String key = strs[0];
            double value = Double.parseDouble(strs[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(strs[0]) + value);
            } else
                map.put(key, value);
        }
        fileReader.close();

        //Max
        for (Double a : map.values())
            if (max < a)
                max = a;

        //show
        for (Map.Entry<String, Double> pair : map.entrySet())
            if (pair.getValue().equals(max))
                System.out.println(pair.getKey());
    }
}