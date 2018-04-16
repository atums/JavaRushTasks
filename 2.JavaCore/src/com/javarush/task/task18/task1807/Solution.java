package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int count = 0;
        char ch;

        while(inputStream.available() > 0) {
            ch = (char) inputStream.read();
            if(ch == ',') {
                count++;
            }
        }
        System.out.println(count);
        inputStream.close();
    }
}
