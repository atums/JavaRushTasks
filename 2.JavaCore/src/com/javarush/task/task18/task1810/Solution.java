package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int count;
        while(true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String str = reader.readLine();
                FileInputStream fileReader = new FileInputStream(str);
                int count = fileReader.available();
                reader.close();
                fileReader.close();
                if(count < 1000) {
                    throw new DownloadException();
                }
//                if(new FileInputStream(str).available() < 1000) {
//                    reader.close();
//                    count = false;
//                    throw new DownloadException();
//                } else {
//                    continue;
//                }
        }
    }

    public static class DownloadException extends Exception {

    }
}
