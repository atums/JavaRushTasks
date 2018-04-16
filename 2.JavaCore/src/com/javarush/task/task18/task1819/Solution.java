package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();

        FileInputStream inputStream1 = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);

        byte[] buff1 = new byte[inputStream1.available()];
        byte[] buff2 = new byte[inputStream2.available()];

        inputStream1.read(buff1);
        inputStream2.read(buff2);

        FileOutputStream outputStream = new FileOutputStream(file1);

        outputStream.write((new String()).getBytes());
        outputStream.write(buff2);
        outputStream.write(buff1);

        inputStream1.close();
        inputStream2.close();
        outputStream.close();
    }
}
