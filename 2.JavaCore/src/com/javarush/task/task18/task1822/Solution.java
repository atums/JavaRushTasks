package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();

//        args[0] = String.valueOf(3);

        BufferedReader reader = new BufferedReader(new FileReader(file));

        while(reader.ready()) {
            String str = reader.readLine();
            if(str.startsWith(args[0])) {
                System.out.println(str);
            }
        }
        reader.close();
    }
}
