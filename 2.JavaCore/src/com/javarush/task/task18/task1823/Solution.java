package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        boolean bool = true;
        while(bool) {
            str = reader.readLine();
            if(!str.equals("exit")) {
               ReadThread th = new ReadThread(str);
               th.start();
            } else {
//                break;
                bool = false;
            }
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        int count = 0;
        int byteRead;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
//            start();
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            HashMap<Byte, Integer> list = new HashMap<Byte, Integer>();
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                byte[] buff = new byte[inputStream.available()];
                while (inputStream.available() > 0) {
                    inputStream.read(buff);
                }
                for(int i = 0; i < buff.length; i++) {
                    if(list.containsKey(buff[i])) {
                        list.put(buff[i], list.get(buff[i]) + 1);
                    } else {
                        list.put(buff[i], 1);
                    }
                }
                inputStream.close();
//                while(inputStream.available() > 0) {
//                    inputStream.read(buff);
//                    for(byte number : buff) {
//                        if(list.containsKey(number)) {
//                            list.put(number, list.get(number) + 1);
//                        } else {
//                            list.put(number, 1);
//                        }
//                    }
//                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(Map.Entry<Byte, Integer> pair : list.entrySet()) {
                if(pair.getValue() > count) {
                    count = pair.getKey();
                    byteRead = pair.getKey();
                }
            }
            resultMap.put(fileName, byteRead);
        }
    }
}
