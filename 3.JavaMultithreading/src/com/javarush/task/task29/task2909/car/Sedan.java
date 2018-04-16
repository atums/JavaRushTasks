package com.javarush.task.task29.task2909.car;

public class Sedan extends Car {
    private static final int MAX_SEDAN_SPEED = 120;

    private Sedan(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

    public Sedan(int numberOfPassengers) {
        super(1, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
