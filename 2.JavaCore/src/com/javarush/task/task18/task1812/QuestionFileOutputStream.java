package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream it;

    public QuestionFileOutputStream(AmigoOutputStream it) {
        this.it = it;
    }

    @Override
    public void flush() throws IOException {
        it.flush();
    }

    @Override
    public void write(int b) throws IOException {
        it.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        it.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        it.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
            System.out.println("Вы действительно хотите закрыть поток? Д/Н");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String str = reader.readLine();
            if(str.equals("Д")) {
                it.close();
            }
            reader.close();


        }
    }

