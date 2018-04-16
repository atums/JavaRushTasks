package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        double n = 0;
        double count = 0;
        double a = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(n != -1) {
            n = Integer.parseInt(reader.readLine());
            if(n != -1) {
                a++;
                count = count + n;
            }
        }
        System.out.println(count / a);
    }
}

