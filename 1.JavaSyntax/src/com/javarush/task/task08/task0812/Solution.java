package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        int a = list.get(0);
        int b = 1;
        int c = 1;
        for (int i = 1; i < list.size(); i++) {
            if ((list.get(i) == a) && (b == c)) {
                b++;
                c++;
                a = list.get(i);
            }
            else {
                if (list.get(i) == a) {
                    b++;
                    a = list.get(i);
                }
                else {
                    b = 1;
                    a = list.get(i);
                }
            }
        }
        System.out.println(c);
    }
}

