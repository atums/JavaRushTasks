package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if(string == null || string.isEmpty())
            throw new TooShortStringException();

        String[] strArr = string.split("\t");
//        System.out.println(strArr.length);
        if(strArr.length <= 2)
            throw new TooShortStringException();

        return strArr[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
