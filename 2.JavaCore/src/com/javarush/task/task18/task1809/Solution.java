package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        String file1 = sc.nextLine();
//        String file2 = sc.nextLine();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();

//        ArrayList<Integer> list = new ArrayList<Integer>();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);

        int fileSize = inputStream.available();

        while (inputStream.available() > 0) {
            byte[] buf = new byte[fileSize];
            byte[] reverseBuf = new byte[buf.length];

            inputStream.read(buf);

            for (int i = buf.length - 1; i >= 0; i--)
                reverseBuf[buf.length - i - 1] = buf[i];

            outputStream.write(reverseBuf);
        }

//        while(inputStream.available() > 0) {
//            int count = inputStream.read();
//            list.add(0, count);
//        }
//        for(int i = 0; i < list.size(); i++) {
//            outputStream.write(list.get(i));
//        }
        inputStream.close();
        outputStream.close();

    }
}
