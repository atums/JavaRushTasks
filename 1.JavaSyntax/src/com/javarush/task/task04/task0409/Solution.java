package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(14, 7);
    }

    public static void closeToTen(int a, int b) {
        int number1 = 10 - a;
        int number2 = 10 - b;
        number1 = abs(number1);
        number2 = abs(number2);
        if(number1 < number2)
            System.out.println(a);
        else
            System.out.println(b);



    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}