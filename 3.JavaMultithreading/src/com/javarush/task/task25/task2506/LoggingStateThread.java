package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread tr;

    public LoggingStateThread(Thread target) {
        this.tr = target;
        System.out.println(tr.getState());
    }

    @Override
    public void run() {
        Thread.State currentState = tr.getState();
        System.out.println(currentState);
        super.run();
        while (!currentState.equals(State.TERMINATED)) {
            Thread.State newState = tr.getState();
            if (!newState.equals(currentState)) {
                System.out.println(newState);
                currentState = newState;
            }
        }
        this.interrupt();
    }
}
