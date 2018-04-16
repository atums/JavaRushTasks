package com.javarush.task.task14.task1421;

class Singleton {

    private static Singleton instance;

    private Singleton() {
        getInstance();
    }

    public static Singleton getInstance() {
        return instance;
    }
}
