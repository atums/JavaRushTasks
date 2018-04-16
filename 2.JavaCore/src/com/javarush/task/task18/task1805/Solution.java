package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(inputStream.read());
        int result;

        while(inputStream.available() > 0) {
            result = inputStream.read();
//            for(int count : list) {
                if(!list.contains(result)) {
                    list.add(result);
                } else {
                    continue;
                }
//            }
        }
        Collections.sort(list);
        for(int count : list) {
            System.out.print(count + " ");
        }
        inputStream.close();
    }
}
