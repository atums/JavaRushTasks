package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
        char arrBasic[] = str.toCharArray();
        ArrayList<Character> listGl = new ArrayList<Character>();
        ArrayList<Character> listSo = new ArrayList<Character>();
        for(char n : arrBasic) {
//            isVowel(n);
            if(isVowel(n) == true) {
                listGl.add(n);

            } else {
                if(n != ' ') {
                    listSo.add(n);
                } else {
                    continue;
                }
            }
        }
        for(int i = 0; i < listGl.size(); i++) {
            System.out.print(listGl.get(i) + " ");
        }
        System.out.print("\n");
        for(int i = 0; i < listSo.size(); i++) {
            System.out.print(listSo.get(i) + " ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}