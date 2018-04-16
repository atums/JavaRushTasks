package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
//            ArrayList<Integer> list = new ArrayList<Integer>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = 1;
            while(list instanceof ArrayList) {
                n = Integer.parseInt(reader.readLine());
                list.add(n);
            }
        } catch(Exception ex) {
            for(Integer result : list) {
                System.out.println(result);
            }
        }
    }
}
