package com.javarush.task.task13.task1326;


        import java.io.*;
        import java.util.TreeSet;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        try {
            TreeSet<Integer> set = new TreeSet<>();
            int num;
            String line;
            while ((line = file.readLine()) != null) {
                num = Integer.parseInt(line);
                if (num % 2 == 0) {
                    set.add(num);
                }
            }
            for (int i : set) {
                System.out.println(i);
            }
            reader.close();
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
            }
        }
    }
}