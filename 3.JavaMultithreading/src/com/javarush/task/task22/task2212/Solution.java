package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if(telNumber.matches("^(\\s*)?(\\+)?([-_():=+]?\\d[-_():=+]?){10,14}(\\s*)?$")) {
            return true;
        }
//        if(telNumber.matches("^[0-9]{10}$")) {
//            return true;
//        }

//        ^[0-9]{10}?[(]{0,2}$
//        ^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$
//        ^((8|\+)[\-]?)?(\(?\d{3}\)?[\-]?)?[\d\-]{7,10}$
//        ^((8|\+7)[\- ]?)?(\(?\d{3}\)?[\- ]?)?[\d\- ]{7,10}$
//        /(?<!\w)(?:(?:(?:(?:\+?3)?8\W{0,5})?0\W{0,5})?[34569]\s?\d[^\w,;(\+]{0,5})?\d\W{0,5}\d\W{0,5}\d\W{0,5}\d\W{0,5}\d\W{0,5}\d\W{0,5}\d(?!(\W?\d))/x
        return false;
    }

    public static void main(String[] args) {
        System.out.println("+380501234567 -t " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567 -t " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67 -t " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567 -t " + checkTelNumber("050123-4567"));
        System.out.println("+38)050(1234567 - f " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7 - f " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567 - f " + checkTelNumber("050ххх4567"));
        System.out.println("050123456 - f " + checkTelNumber("050123456"));
        System.out.println("(0)501234567 - f " + checkTelNumber("(0)501234567"));
    }
}
