package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        return c;
    }

    public static void main(String[] args) {
        System.out.println(calculate(true, true, true, false)); // return true ( no d )
        System.out.println(calculate(false, false, false, true));
        System.out.println();
        System.out.println(calculate(false, true, true, true)); // return true ( no a )
        System.out.println(calculate(true, true, false, true));
        System.out.println();
        System.out.println(calculate(true, false, true, true)); // return true ( no b )
        System.out.println(calculate(true, true, false, true));
        System.out.println();
        System.out.println(calculate(true, true, false, false));
        System.out.println(calculate(false, false, true, false)); // return true ( no a, b, d )
    }
}
