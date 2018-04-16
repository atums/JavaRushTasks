package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        String str3 = reader.readLine();

        int a = Integer.parseInt(str1);
        int b = Integer.parseInt(str2);
        int c = Integer.parseInt(str3);

        if(a == b && a == c && b == c) {
            System.out.println(a + " " + b + " " + c);
        } else if(a == b){
            System.out.println(a + " " + b);
        }else if(a == c) {
            System.out.println(a + " " + c);
        }else if(b == c) {
            System.out.println(b + " " + c);
        }
    }
}
