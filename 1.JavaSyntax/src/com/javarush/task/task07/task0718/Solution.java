package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        InputStreamReader inputSR = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputSR);

        for(int i = 0; i < 10; i++) {
            String str = reader.readLine();
            list.add(str);
        }
        int n = list.get(0).length();
        for(int i = 1; i < list.size(); i++) {
            if(n < list.get(i).length()) {
                n = list.get(i).length();
//
//
            } else {
                System.out.println(i);
                break;
            }
        }
    }
}

