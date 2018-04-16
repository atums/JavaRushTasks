package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {

    public static List<String> words = new ArrayList<String>();
    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerFile.readLine();
//        String fileName  = "e:\\!.txt";
        readerFile.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
         while(reader.ready()) {
             String s = reader.readLine();
             String[] srt = s.split("[\\p{P}\\s\\t\\r]");
             int count = 0;
             for(String strRes : srt) {
                 for(String checkStr : words) {
                    if(strRes.trim().equals(checkStr)) {
                        count++;
                    }
                 }
             }
             if(count == 2) {
                 System.out.println(s);
             }
         }
         reader.close();
    }
}
