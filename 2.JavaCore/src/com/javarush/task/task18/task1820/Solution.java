package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String file1 = sc.nextLine();
        String file2 = sc.nextLine();
        double number;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Long> listTwo = new ArrayList<Long>();

        FileWriter outputStream = new FileWriter(file2);
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        while(reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();

        for(String str : list) {
            for(String str2 : str.split(" ")) {
                number = Double.parseDouble(str2);
                listTwo.add(Math.round(number));
            }
        }

        for(Long writeLong : listTwo) {
            outputStream.write(writeLong.toString() + " ");
        }
        outputStream.close();
    }
}
