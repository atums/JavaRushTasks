package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        double t = scanner.nextDouble();
        for (int i = 0; i < 60; i += 5) {
            if (t >= i && t < (i + 3))
                System.out.println("зелёный");
            if (t >= (i + 3) && t < (i + 4))
                System.out.println("желтый");
            if (t >= (i + 4) && t < (i + 5))
                System.out.println("красный");
        }
    }
}