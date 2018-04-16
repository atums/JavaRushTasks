package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        FileReader fReader = new FileReader(file1);
        FileWriter fWriter = new FileWriter(file2);
//        while(fReader.ready()) {
//            list.add(fReader.read());
//        }
//        fReader.close();
//
//        for(int i = 2; i < list.size(); i += 2) {
//            fWriter.write(list.get(i));
//        }
//        fWriter.close();

        int i = 1;
        while(fReader.ready()) {
            int result = fReader.read();
            if(i % 2 == 0) {
                fWriter.write(result);
            }
            i++;
        }
        fReader.close();
        fWriter.close();
    }
}
