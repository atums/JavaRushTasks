package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator... vararg) {
            this.comparators = vararg;
        }

        @Override
        public int compare(Object o1, Object o2) {
            int result = 0;
            for(Comparator<T> comp : comparators) {
                result = comp.compare((T)o1, (T)o2);

                if(result != 0) {
                    break;
                }
            }
            return result;
        }
    }
}
