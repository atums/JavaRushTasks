package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
//    public static String fileName = "e:\\!.txt";

    FileOutputStream it;

    public AmigoOutputStream(FileOutputStream it) throws FileNotFoundException {
        super(fileName);
        this.it = it;
    }

    public void write(int data) throws IOException {
        it.write(data);
    }
    public void write(byte[] b, int off, int len) throws IOException {
        it.write(b, off, len);
    }
    public void write(byte[] data) throws IOException {
        it.write(data);
    }

    public void flush() throws IOException {
        it.flush();
    }

    public void close() throws IOException {
        it.flush();
//        StringBuilder sb = new StringBuilder();
//        sb.append("JavaRush © All rights reserved.").append('\n');
//        String data = sb.toString();
//        InputStream is = new ByteArrayInputStream(data.getBytes());
        String str = "JavaRush © All rights reserved.";
        it.write(str.getBytes());
        it.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
