package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        //напишите тут ваш код
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i = 0; i < 40; i++) {
            for(int j = i; j < n; j++) {
                System.out.print(arr[j]);

            }
            System.out.print("\n");
        }
    }

}

