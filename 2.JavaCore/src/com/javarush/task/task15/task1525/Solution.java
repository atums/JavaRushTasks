package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME),"Windows-1251"));
            String str;
            while((str = readerFile.readLine()) != null) {
                lines.add(str);
            }
        } catch(IOException ex) {
            ex.getStackTrace();
        }
    }


    public Solution() throws FileNotFoundException {
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
