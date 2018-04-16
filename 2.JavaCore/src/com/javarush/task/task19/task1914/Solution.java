package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        int operandOne;
        int operandTwo;
        System.setOut(stream);

        testString.printSomething();

        System.setOut(oldStream);

        String[] str = outputStream.toString().split(" ");
        operandOne = Integer.parseInt(str[0]);
        operandTwo = Integer.parseInt(str[2]);

        if(str[1].equals("+")) {
            System.out.println(outputStream.toString().replaceAll("= ", "= " + (operandOne + operandTwo)));
        }
        if(str[1].equals("-")) {
            System.out.println(outputStream.toString().replaceAll("= ", "= " + (operandOne - operandTwo)));
        }
        if(str[1].equals("*")) {
            System.out.println(outputStream.toString().replaceAll("= ", "= " + (operandOne * operandTwo)));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

