package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread tr;

    @Override
    public void run() {
//        System.out.println(tr.getName());
        while(!tr.isInterrupted()) {

            try {
                Thread.sleep(0);
                System.out.println(tr.getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void start(String threadName) {
        this.tr = new Thread(this, threadName);
//        this.tr.setName(threadName);
        tr.start();
    }

    @Override
    public void stop() {
        tr.interrupt();
    }
}
