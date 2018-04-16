package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        boolean exit = false;
        int count = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(!exit) {
            int a = Integer.parseInt(reader.readLine());
            count = count + a;
            if(a == -1) {
                exit = true;
            }
        }
        System.out.println(count);
    }
}
