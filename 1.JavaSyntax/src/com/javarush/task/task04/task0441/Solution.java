package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        if(arr[0] == arr[1] && arr[1] == arr[2] && arr[0] == arr[2]) {
            System.out.println(arr[0]);
        } else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
            System.out.println(arr[1]);
        } else {
            System.out.println(arr[1]);
        }

    }
}
