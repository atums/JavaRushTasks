package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String str = null;
            str = bufferedReader.readLine();
        return str;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> listDish= new ArrayList<>();
        writeMessage("Выберите блюда. Сделать заказ 'exit'");
        writeMessage(Dish.allDishesToString());

        while(true) {
            String dish = readString();
            boolean noDishe = true;
            if(dish.equals("exit")) {
                break;
            }
            if(dish.isEmpty()) {
                writeMessage("Блюдо не выбрано");
                continue;
            }
            for(Dish dishEnum : Dish.values()) {
                if(dishEnum.toString().equals(dish)) {
                    listDish.add(dishEnum);
                    noDishe = false;
                }
            }
            if(noDishe) {
                writeMessage("Такого блюда нет");
            }
        }
        return listDish;
    }

}
