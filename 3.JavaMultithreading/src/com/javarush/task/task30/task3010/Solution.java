package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
            try {
                String str = args[0];
//        String str = "00";
//        String str = "12AS08z";
//        String str = "12AS08Z/";
                for(int i = 2; i < 37; i++) {
                    if(isNumber(str, i)) {
                        System.out.println(i);
                        break;
                    } else {
//                        System.out.println("It isn't number: " + i); ///
                        if(i == 36) {
                            System.out.println("incorrect");
                        }
                    }
                }
            }catch(Exception ex) {
            }

    }

    private static boolean isNumber(String str, int i) {
        boolean result = false;
        try {
//            Integer.parseInt(str, i);
            new BigDecimal(new BigInteger(str, i));
            result = true;
        } catch(Exception ex) {
        }
        return result;
    }
}