package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String alphabetL = "abcdefghijklmnopqrstuvwxyz";
        String alphabetH = alphabetL.toUpperCase();
        int count = 0;
        FileReader reader = new FileReader(args[0]);
        while(reader.ready()) {
            char ch = (char) reader.read();

            if(alphabetL.indexOf(ch) > - 1 || alphabetH.indexOf(ch) > - 1) {
                count++;
            }
        }
        reader.close();
        System.out.println(count);
    }
}
