package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String file = args[0];
//        String file = "e:\\!!.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while(reader.ready()) {
            String str = reader.readLine();
            String name = str.replaceAll("[\\w]", "").trim();

            String[] dateBirth = str.substring(name.length()).trim().split(" ");
//            try {
                int day = Integer.parseInt(dateBirth[0]);
                int month = Integer.parseInt(dateBirth[1]);
                int year = Integer.parseInt(dateBirth[2]);

                Date date = new GregorianCalendar(year, month-1, day).getTime();
                PEOPLE.add(new Person(name, date));
//            } catch(NumberFormatException ex) {
//
//            }


        }
        reader.close();

//        test(PEOPLE);
    }

//    public static void test(List<Person> PEOPLE) {
//
//        for(Person p : PEOPLE) {
//            System.out.println(p.getName() + " " + p.getBirthday());
//        }
//    }
}
