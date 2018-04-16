package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties props = new Properties();
    static String fileName;

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(System.in));
        fileName = readerFile.readLine();
        readerFile.close();

        FileInputStream inputStream = new FileInputStream(fileName);
//        FileOutputStream outputStream = new FileOutputStream(fileName);

        load(inputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
//        PrintWriter writer = new PrintWriter(outputStream);
//
//        for(Map.Entry<String, String> par : properties.entrySet()) {
//            writer.println(par.getKey() + ":" + par.getValue());
//        }
//        writer.close();
        props.clear();
        for(Map.Entry<String, String> pair : properties.entrySet()) {
            props.setProperty(pair.getKey(), pair.getValue());
        }
        props.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        while(reader.ready()) {
//            String[] strArr = reader.readLine().split("[=|:| = | : ]");
//            properties.put(strArr[0], strArr[1]);
//        }
//        reader.close();

        props.load(inputStream);

        for(Map.Entry<Object, Object> pair : props.entrySet()) {
            properties.put((String) pair.getKey(), (String)pair.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        sol.fillInPropertiesMap();

        FileOutputStream outputStream = new FileOutputStream(fileName);
        sol.save(outputStream);
        outputStream.close();
    }
}
