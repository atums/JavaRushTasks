package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(args[0]);
        int length = 0;
        int count = 0;
        while(reader.ready()) {
            char ch = (char) reader.read();
            length ++;
            if(ch == ' ') {
                count++;
            }
        }
        reader.close();
        System.out.println(String.format("%.2f", ((float) count / length) * 100));
    }
}
