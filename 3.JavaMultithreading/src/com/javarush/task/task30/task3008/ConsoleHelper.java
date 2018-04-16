package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String str = null;
        boolean bool = true;
        while(bool) {
            try {
                str = br.readLine();
                bool = false;
            } catch (IOException ex) {
//            ex.printStackTrace();
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return str;
    }

    public static int readInt() {
        int number = 0;
        boolean bool = true;
        while(bool) {
            try {
                number = Integer.parseInt(readString());
                bool = false;
            } catch(NumberFormatException ex) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return number;
    }
}
