package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileOne = sc.nextLine();
        String fileTwo = sc.nextLine();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader rederFileOne;
        BufferedReader rederFileTwo;

/*        try {
//            fileOne = reader.readLine();
//            fileTwo = reader.readLine();
//            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            rederFileOne = new BufferedReader(new InputStreamReader(new FileInputStream(fileOne)));
            while(rederFileOne.ready()) {
                //
//                System.out.println(rederFileOne.readLine());
                //
                allLines.add(rederFileOne.readLine());
            }
            rederFileTwo = new BufferedReader(new InputStreamReader(new FileInputStream(fileTwo)));
            while(rederFileTwo.ready()) {
                //
//                System.out.println(rederFileTwo.readLine());
                //
                forRemoveLines.add(rederFileTwo.readLine());
            }
            rederFileOne.close();
            rederFileTwo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {

//        for(String resultAll : allLines) {
/*            for(String resultRemove : forRemoveLines) {
                if(resultAll.equals(resultRemove)) {
                    allLines.remove(resultAll);*/

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
            return;
                } else {
/*                    Iterator iterator = allLines.iterator();
                    while(iterator.hasNext()) {
                        allLines.remove(iterator.next());
                    }*/
//                    for(int i = 0; i < allLines.size(); i++) {
//                        allLines.remove(i);
//                    }
                    allLines.clear();
                    throw new CorruptedDataException();
                }
//            }
        }
    }

