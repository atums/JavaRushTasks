package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        boolean result = false;
        Date checkData = new Date(date);
        String[] strArr = date.split("\\s");

        int year = Integer.parseInt(strArr[strArr.length - 1]);
        Date startDate = new Date(year - 1900, 0, 1);
        long msTime = checkData.getTime() - startDate.getTime();
        long days = (((msTime / 1000) / 3600) / 24);
        if(days % 2 == 0) {
            result = true;
        }

        return result;
    }
}
