package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[3];
        int a = 0;
        int b = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        for(int i = 0; i < 3; i++) {
            if(arr[i] == 0)
                continue;
            if(arr[i] > 0) {
                a++;
            } else {
                b++;
            }
        }
        System.out.println("количество отрицательных чисел: " + b);
        System.out.println("количество положительных чисел: " + a);

    }
}
