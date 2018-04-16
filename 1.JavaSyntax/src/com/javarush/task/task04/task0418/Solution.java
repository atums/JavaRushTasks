package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n0 = Integer.parseInt(reader.readLine());
        int n1 = Integer.parseInt(reader.readLine());
        if(n0 <= n1) {
            System.out.println(n0);
        }else {
            System.out.println(n1);
        }

    }
}