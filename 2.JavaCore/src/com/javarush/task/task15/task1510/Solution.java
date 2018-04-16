package com.javarush.task.task15.task1510;

/* 
Все лишнее - прочь!
*/

public class Solution {
    public static void main(String[] args) {
        add((short) 1, 2f); //3
        add(1, 2); //1
        add(2d, 2); //2
//        add("1",2d);
//        add((byte) 1, 2d);
    }

    public static void add(int i, int j) { //1
        System.out.println("Integer addition");
    }

    public static void add(int i, double j) { //3
        System.out.println("Integer and double addition");
    }

    public static void add(double i, double j) { //2
        System.out.println("Double addition");
    }
}
