package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        int minBit = 127;

        FileInputStream inputStream = new FileInputStream(fileName);
        while(inputStream.available() > 0) {
            int result = inputStream.read();
            if(result < minBit) {
                minBit = result;
            }
        }
        System.out.println(minBit);
        inputStream.close();
    }
}
