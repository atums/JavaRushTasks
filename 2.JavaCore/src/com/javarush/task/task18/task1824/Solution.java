package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = null;
            try {
                str = reader.readLine();
                FileInputStream inputStream = new FileInputStream(str);
                inputStream.close();
            } catch (IOException ex) {
//                ex.printStackTrace();
                System.out.println(str);
                break;
            }
        }
    }
}
