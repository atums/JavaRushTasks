package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];

//        String file1 = "e:\\1.txt", file2 = "e:\\2.txt";

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        while(reader.ready()) {
            String[] str = reader.readLine().split(" ");
            for(String wordTry : str) {

                if(!wordTry.matches("^\\D*$")) {
//                    System.out.println(wordTry);
                    writer.write(wordTry + " ");
                } else {

                }
            }
        }
        reader.close();
        writer.close();
    }
}
