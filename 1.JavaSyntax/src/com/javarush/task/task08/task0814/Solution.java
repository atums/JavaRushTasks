package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet createSet() {
        HashSet set = new HashSet();
        for(int i = 0; i < 20; i++) {
            int n = (int)(i + ( Math.random() * 100));
            set.add(n);
        }
        return set;
    }
    public static HashSet removeAllNumbersMoreThan10(HashSet set) {
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            if ((int)iterator.next() > 10) {
                iterator.remove();
            }
        }
        return set;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.createSet());
        System.out.println(sol.removeAllNumbersMoreThan10(sol.createSet()));
    }
}