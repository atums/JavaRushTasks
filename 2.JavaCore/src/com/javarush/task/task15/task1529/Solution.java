package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static Flyable result;

    public static void reset() {
        //add your code here - добавьте код тут
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = reader.readLine();
            if(str.equals("helicopter")) {
                result = new Helicopter();
                reader.close();
            } else if(str.equals("plane")) {
                int passangers = Integer.parseInt(reader.readLine());
                result = new Plane(passangers);
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
