package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int N = Integer.parseInt(reader.readLine());
        while(N > 0) {
            System.out.println(str);
            N--;
        }

    }
}
