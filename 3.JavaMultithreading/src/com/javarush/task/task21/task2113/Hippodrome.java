package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public Hippodrome() {
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome();

        Horse horse01 = new Horse("Horse01", 3.0d, 0.0d);
        Horse horse02 = new Horse("Horse02", 3.0d, 0.0d);
        Horse horse03 = new Horse("Horse03", 3.0d, 0.0d);

        game.getHorses().add(horse01);
        game.getHorses().add(horse02);
        game.getHorses().add(horse03);

        try {
            game.run();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        game.printWinner();
    }

    void run() throws InterruptedException {
        for(int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    void print() {
        for(Horse moveHorse : horses) {
            moveHorse.print();
        }
        for(int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }

    void move() {
        for(Horse moveHorse : horses) {
            moveHorse.move();
        }
    }

    public Horse getWinner() {
        double winHorse = 0.0d;
        int indexWin = 0;
        Horse win;
        for(int i = 0; i < horses.size(); i++) {
            if(horses.get(i).getDistance() > winHorse) {
                winHorse = horses.get(i).getDistance();
                indexWin = i;
            }
        }
        return horses.get(indexWin);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
