package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e); // ArithmeticException
        }
        try {
            int arr[] = new int[3];
            arr[4] = 5;

        } catch (Exception e) {
            exceptions.add(e);// ArrayIndexOutOfBoundsException
        }
        try {
            String str = "qqq";
            int n = Integer.parseInt(str);

        } catch (Exception e) {
            exceptions.add(e); // NumberFormatException
        }
        try {
            int arr[] = new int[-3];

        } catch (Exception e) {
            exceptions.add(e); // NegativeArraySizeException
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("c:/!.txt")));

        } catch (Exception e) {
            exceptions.add(e); // FileNotFoundException
        }
        try {
            Integer n = new Integer(2);
            n = null;
            int m = n;

        } catch (Exception e) {
            exceptions.add(e); // NullPointerException
        }
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("c:/!.txt"))));

        } catch (Exception e) {
            exceptions.add(e); // FileNotFoundException
        }
        try {
            String str = "";
            str.charAt(10);

        } catch (Exception e) {
            exceptions.add(e); // StringIndexOutOfBoundsException
        }
        try {
            Object str = new String("qqq");
            System.out.println((Integer) str);

        } catch (Exception e) {
            exceptions.add(e); // ClassCastException
        }
        try {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);

            list.get(3);

        } catch (Exception e) {
            exceptions.add(e); //IndexOutOfBoundsException
        }


        //напишите тут ваш код

    }
}
