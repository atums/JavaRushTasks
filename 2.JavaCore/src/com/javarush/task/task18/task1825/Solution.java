package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> treeSet = new TreeSet<String>();
        String str;
        String wFile = null;
        boolean bool = true;
        while(bool) {
            str = reader.readLine();
            if(str.equals("end")) {
                bool = false;
            } else {
                // тут надо отрезать part# от Lion.avi.part# и получить (wFile)Lion.avi
//                wFile = treeSet.get(0).split(".part")[0];
                wFile = str.split(".part")[0];

                treeSet.add(str);
            }
        }
        reader.close();

        FileOutputStream outputStream = new FileOutputStream(wFile);
        for(String file : treeSet) {
            FileInputStream inputStream = new FileInputStream(file);
            byte[] buff = new byte[inputStream.available()];
            inputStream.read(buff);

            outputStream.write(buff);
            inputStream.close();
        }
        outputStream.close();
    }
}
