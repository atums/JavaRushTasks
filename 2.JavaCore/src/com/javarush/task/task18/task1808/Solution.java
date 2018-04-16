package com.javarush.task.task18.task1808;

/* 
Разделение файла
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
        String file3 = sc.nextLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);
//        int length = inputStream.available();
//        int buffSize1;
//        int buffSize2;

//        if(length % 2  == 0) {
//            buffSize1 = buffSize2 = length / 2;
//        } else {
//            buffSize1 = length / 2;
//            buffSize2 = length / 2 + 1;
//        }

        int fileSize = inputStream.available();
        int part1Size = fileSize % 2 == 0 ? fileSize / 2 : fileSize / 2 + 1;

        while(inputStream.available() > 0) {
//            byte[] buff1 = new byte[buffSize1];
//            byte[] buff2 = new byte[buffSize2];

            byte[] buff1 = new byte [part1Size];
            byte[] buff2 = new byte [fileSize - part1Size];

            inputStream.read(buff1);
            inputStream.read(buff2);
            outputStream.write(buff1);
            outputStream2.write(buff2);
        }

        inputStream.close();
        outputStream.close();
        outputStream2.close();
    }
}
