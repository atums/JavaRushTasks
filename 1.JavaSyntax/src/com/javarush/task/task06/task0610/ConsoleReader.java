package com.javarush.task.task06.task0610;

import java.io.*;


/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        return str;

    }

    public static int readInt() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nInt = Integer.parseInt(reader.readLine());
        return nInt;

    }

    public static double readDouble() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double nDob = Double.parseDouble(reader.readLine());
        return nDob;

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean nBoo = Boolean.parseBoolean(reader.readLine());
        return  nBoo;

    }

    public static void main(String[] args) {

    }
}
