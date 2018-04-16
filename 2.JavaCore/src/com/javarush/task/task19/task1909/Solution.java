package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("e:\\1.txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("e:\\2.txt"));

        while(bufferedReader.ready()) {
            String str = bufferedReader.readLine();
            char[] arrChar = str.toCharArray();

            for(char result : arrChar) {
                if(result == '.') {
                    bufferedWriter.write("!");
                } else {
                    bufferedWriter.write(result);
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
