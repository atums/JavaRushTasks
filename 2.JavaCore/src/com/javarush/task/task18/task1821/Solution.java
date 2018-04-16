package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream reader = new FileInputStream(args[0]);
        TreeMap<Byte, Integer> map = new TreeMap<Byte, Integer>();

        byte[] buff = new byte[reader.available()];

        while(reader.available() > 0) {
            reader.read(buff);
        }

        for(int i = 0; i < buff.length; i++) {
            if(map.containsKey(buff[i])) {
                map.put(buff[i], map.get(buff[i]) + 1);
            } else map.put(buff[i], 1);
        }

        for(Map.Entry pair : map.entrySet()) {
//            Byte key = pair.getKey();
//            Integer value = pair.getValue();
            System.out.println((char)((byte) pair.getKey()) + " " + pair.getValue());

        }
        reader.close();
    }
}
