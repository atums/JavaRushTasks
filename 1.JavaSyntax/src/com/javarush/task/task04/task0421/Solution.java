package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        int a = str1.length();
        int b = str2.length();

        if(str1.equals(str2)) {
            System.out.println("Имена идентичны");
        } else if(a == b) {
            System.out.println("Длины имен равны");
        }
    }
}
