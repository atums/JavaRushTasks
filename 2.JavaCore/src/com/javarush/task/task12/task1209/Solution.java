package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    static int min(int i, int i2) {
        if(i < i2) {
            return i;
        } else {
            return i2;
        }
    }
    static long min(long l, long l2) {
        if(l < l2) {
            return l;
        } else {
            return l2;
        }
    }
    static double min(double d, double d2) {
        if(d < d2) {
            return d;
        } else {
            return d2;
        }
    }
}
