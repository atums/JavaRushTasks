package com.javarush.task.task29.task2909.car;

public class Truck extends Car {
    private static final int MAX_TRUCK_SPEED = 80;

    private Truck(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }

    public Truck(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
