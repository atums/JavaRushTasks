package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        int n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        for(int i = 0; n > 0; i++) {
            if(n%2==0){
                even++;
            }else{
                odd++;
            }
            n/=10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);

    }
}
