package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

// Тут решение рекурсией
//    public static String getAllNumbersBetween(int a, int b) {
//        if (a > b) {
//            return a + " " + recursion(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + " " + recursion(a + 1, b);
//        }
//    }

    public static String getAllNumbersBetween(int a, int b) {
//        Решение через for и String
//        String str = "";
//        if (a == b) {
//            return Integer.toString(a);
//        } else if (a > b) {
//            for (int i = a; i >= b; i--) {
//                str = str + " " + i;
//            }
//        } else {
//            for (int i = a; i <= b; i++) {
//                str = str + " " + i;
//            }
//        }
//            return str;


//        Навязанное решение через while и StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        if (a == b) {
            return Integer.toString(a);
        } else {
            if (a > b) {
                while (a > b) {
                    stringBuilder.append(" ").append(--a);
                }
            } else {
                while (a < b) {
                    stringBuilder.append(" ").append(++a);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
//        numberA = 30;
//        numberB = 56;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}