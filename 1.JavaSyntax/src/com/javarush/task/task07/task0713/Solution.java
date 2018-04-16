package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> listEverything = new ArrayList<Integer>();
        ArrayList<Integer> listX3 = new ArrayList<Integer>();
        ArrayList<Integer> listX2 = new ArrayList<Integer>();
        ArrayList<Integer> listOther = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 20; i++) {
            listEverything.add(Integer.parseInt(reader.readLine()));
        }
        for(int i = 0; i < listEverything.size(); i++) {
            if(listEverything.get(i) % 3 == 0) {
                listX3.add(listEverything.get(i));
                if(listEverything.get(i) % 2 == 0) {
                    listX2.add(listEverything.get(i));
                }
            } else if(listEverything.get(i) % 2 == 0) {
                listX2.add(listEverything.get(i));
            } else {
                listOther.add(listEverything.get(i));
            }
        }
        Solution.printList(listX3);
        Solution.printList(listX2);
        Solution.printList(listOther);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
