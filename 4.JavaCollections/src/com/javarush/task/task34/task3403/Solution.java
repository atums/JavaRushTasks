package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        int coint = 2;

        while (n >= coint) {
            if ((n % coint) == 0) {
                if (n != coint) {
                    System.out.print(coint + " ");
                    recursion(n / coint);
                } else {
                    System.out.print(coint);
                }
                return;
            }
            coint++;
        }
    }
}
