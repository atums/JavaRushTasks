package com.javarush.task.task18.task1818;

/* 
Два в одном
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

        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream0 = new FileInputStream(file2);
        FileInputStream inputStream1 = new FileInputStream(file3);

        byte[] buff0 = new byte[inputStream0.available()];
        byte[] buff1 = new byte[inputStream1.available()];


        inputStream0.read(buff0);
        inputStream1.read(buff1);

        outputStream.write(buff0);
        outputStream.write(buff1);

        inputStream0.close();
        inputStream1.close();
        outputStream.close();
    }
}
