package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strFile = reader.readLine();

        FileOutputStream fos = new FileOutputStream(strFile);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));

        String str = "";
        while(!str.equals("exit")) {
            str = reader.readLine();
            writer.append(str + "\n");
            writer.flush();
        }

        writer.close();

    }
}
