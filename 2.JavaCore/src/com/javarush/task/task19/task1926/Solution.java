package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerFile.readLine();
//        String fileName = "e:\\!.txt";
        readerFile.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while(reader.ready()) {
            String str = reader.readLine();
            char[] symbol = str.toCharArray();
            for(int i = symbol.length - 1; i > -1; i--) {
                System.out.print(symbol[i]);
            }
            System.out.print("\n");
        }
        reader.close();

    }
}
