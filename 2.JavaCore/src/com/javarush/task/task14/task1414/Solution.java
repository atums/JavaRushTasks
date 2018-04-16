package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        String str;
        Movie movie;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true)
            {
                str = reader.readLine();
                movie = MovieFactory.getMovie(str);
                if (str.equals("cartoon")) {
                    System.out.println(movie.getClass().getSimpleName());
                    continue;
                }

                if (str.equals("thriller")) {
                    System.out.println(movie.getClass().getSimpleName());
                    continue;
                }

                if (str.equals("soapOpera")) {
                    System.out.println(movie.getClass().getSimpleName());
                    continue;
                }

                break;
            }


        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            //напишите тут ваш код, пункты 5,6

            return movie;
        }
    }

    static abstract class Movie {
//        public String movie;
    }

    static class SoapOpera extends Movie {

    }

    static class Thriller extends Movie{

    }

    static class Cartoon extends Movie{

    }

    //Напишите тут ваши классы, пункт 3
}
