package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String srt = new BufferedReader(new FileReader("e:\\!.txt")).readLine();
            String[] arrStr = srt.split("\\s");

            return new Person(arrStr[0], arrStr[1], arrStr[2], new Date(Integer.parseInt(arrStr[3]), Integer.parseInt(arrStr[4]), Integer.parseInt(arrStr[5])));
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
