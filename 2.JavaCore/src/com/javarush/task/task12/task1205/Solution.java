package com.javarush.task.task12.task1205;

/* 
Определимся с животным
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
        String str;
        if(o instanceof Cow) {
            str = "Корова";
        } else if(o instanceof Dog) {
            str = "Собака";
        } else if(o instanceof Whale) {
            str = "Кит";
        } else {
            str = "Неизвестное животное";
        }



        return str;
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
