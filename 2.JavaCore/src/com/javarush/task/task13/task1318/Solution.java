package com.javarush.task.task13.task1318;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();

            FileInputStream fis = new FileInputStream(str);
            while (fis.available() > 0) {
                System.out.print((char) fis.read());
            }
            System.out.println();
            fis.close();
            reader.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

}