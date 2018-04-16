package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rFile = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(rFile));
        String specialWord = "world";
        int count = 0;

        while(fileReader.ready()) {
            String str = fileReader.readLine();
            String[] words = str.split("\\W");
            for(String result : words) {
                if(result.equals(specialWord)) {
                    count++;
                }
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}
