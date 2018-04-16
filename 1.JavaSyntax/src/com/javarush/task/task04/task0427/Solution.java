package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    static String ch;
    static String str;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
//        String ch;
        if(n >= 1 && n <= 999) {
            if(n % 2 == 0) {
                ch = "четное ";
            } else {
                ch = "нечетное ";
            }
            parser(n);
            System.out.println(ch + str);
        }
    }

    public static void parser(int a) {
        int count = 0;
        while(a > 0) {
            count++;
            a = a / 10;
//            System.out.println(count);
//            System.out.println(a);

        }
        if(count == 3) {
           str = "трехзначное число";
        } else if(count == 2) {
            str = "двузначное число";
        } else {
            str = "однозначное число";
        }


    }
}
