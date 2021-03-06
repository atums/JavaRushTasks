package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
            return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet;
    }

    public int getTotalCookingTime() {
        int timeForCook = 0;
        for(Dish listDish : dishes) {
            timeForCook += listDish.getDuration();
        }
        return timeForCook;
    }
}

