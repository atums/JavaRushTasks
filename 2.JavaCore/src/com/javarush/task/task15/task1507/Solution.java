package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Integer m, Integer n, String value) {
        System.out.println(value + " != " + (m + n));
    }

    public static void printMatrix() {
        System.out.println("Default!");
    }

    public static int printMatrix(int m, Integer n, String value) {
        return m;
    }

    public static void printMatrix(int m, int n) {
        int x = n*m;
    }

    public static Integer printMatrix(String value) {
        return Integer.parseInt(value);
    }

    public static void printMatrix(String value, int m, int n) {
        System.out.println(value + " " + m + " " + n);
    }

    public static void printMatrix(int m) {
        m = Integer.parseInt(null);
    }

    public static int printMatrix(ArrayList<Integer> list) {
        list.add(13);
        return list.get(0);
    }
}
