package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] s = getTokens("level22.lesson13.task01", ".");

        for(String str : s) {
            System.out.print(str);
        }
    }
//    public static String [] getTokens(String query, String delimiter) {
//        StringTokenizer token = new StringTokenizer(query.replace(delimiter, ", #"), "#");
//        ArrayList<String> list = new ArrayList<>();
//        while (token.hasMoreTokens()) {
//            list.add(token.nextToken());
//        }
//        String[] arrayOfStrings;
//        arrayOfStrings = list.toArray(new String[list.size()]);
//        return arrayOfStrings;
//    }
    //        System.out.println(token.countTokens());

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] result = new String[st.countTokens()];

        for (int i=0; st.hasMoreElements();i++) {
            result[i] = st.nextToken();
        }

        return result;
    }
}
