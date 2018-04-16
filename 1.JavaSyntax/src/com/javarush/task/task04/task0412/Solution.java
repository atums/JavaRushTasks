package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String str;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
        int num = Integer.parseInt(str);

        if(num > 0) {
            num = num * 2;
        } else if(num < 0) {
            num++;
        }
        System.out.println(num);


    }

}