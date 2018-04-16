package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
/*    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rederFile = new BufferedReader(new InputStreamReader(System.in));
//        String file = rederFile.readLine();
        String file = "e:\\!.txt";
        rederFile.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String words = "";

        while (reader.ready()) {
            String string = reader.readLine() + " ";
            words += string;
        }
        reader.close();

        String[] str = words.split(" ");

        for(int i = 0; i < str.length; i++) {
            for(int j = i + 1; j < str.length; j++) {
                StringBuilder sb = new StringBuilder(str[i]);
                sb.reverse();

                if(sb.toString().equals(str[j])) {
                    Pair pair = new Pair();
                    pair.first = str[i];
                    pair.second = str[j];
                    int check = 0;
                    for(Pair pairCheck : result) {
                        if(str[i].equals(pairCheck.first) || str[j].equals(pairCheck.second)) {
                            check = 1;
                            break;
                        }
                    }
                    if(check == 0) {
                        result.add(pair);
                    }
                }
            }
        }

//        for(Pair pair : result) {
//            System.out.println("Читаем пару : " +  pair);
//        }
    }
*/

    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader readerF = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (readerF.ready()) {
            sb.append(readerF.readLine() + " ");
        }
        readerF.close();
        String[] arr = sb.toString().trim().split("\\s+");
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(i)) continue;
            for (int j = i+1; j < arr.length; j++) {
                String x = new StringBuilder(arr[j]).reverse().toString();
                if (x.equals(arr[i])) {
                    Pair pair = new Pair();
                    pair.first = x;
                    pair.second = arr[j];
                    result.add(pair);
                    set.add(j);
                    break;
                }
            }
        }

        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
