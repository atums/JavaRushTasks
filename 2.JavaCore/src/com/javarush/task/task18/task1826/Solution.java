package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        if(args[0].startsWith("-e")) {
            String fileName = args[1]; //Файл из которого читаем для шифровки
            String fileOutput = args[2]; //Файл куда пишем шифровку
            FileInputStream inputStream = new FileInputStream(fileName);
            FileOutputStream outputStream = new FileOutputStream(fileOutput);
//            ArrayList<Integer> list = new ArrayList<Integer>();
            while(inputStream.available() > 0) {
//                list.add(inputStream.read() + 1);
                int number = inputStream.read() + 1;
                outputStream.write(number);
            }
            inputStream.close();
            outputStream.close();
        }
        if(args[0].startsWith("-d")) {
            String fileName = args[1]; //Файл из которого читаем для шифровки
            String fileOutput = args[2]; //Файл куда пишем шифровку
            FileInputStream inputStream = new FileInputStream(fileName);
            FileOutputStream outputStream = new FileOutputStream(fileOutput);
//            ArrayList<Integer> list = new ArrayList<Integer>();
            while(inputStream.available() > 0) {
//                list.add(inputStream.read() + 1);
                int number = inputStream.read() - 1;
                outputStream.write(number);
            }
            inputStream.close();
            outputStream.close();
        }
    }

}
