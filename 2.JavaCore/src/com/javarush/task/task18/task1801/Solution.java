package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        int begin = 0;

        FileInputStream inputStream = new FileInputStream(fileName);
        while(inputStream.available() > 0) {

            int result = inputStream.read();
            if(result > begin) {
                begin = result;
            }
        }
        System.out.println(begin);
        inputStream.close();
    }
}
