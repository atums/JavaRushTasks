package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String arch[] = {null, "понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int num = Integer.parseInt(str);

        if(num >= 1 && num <= 7) {
            System.out.println(arch[num]);
        } else {
            System.out.println("такого дня недели не существует");
        }
    }
}