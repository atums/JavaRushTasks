package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {

//        try {
//            for(int i = 1; i < map.size(); i++) {
//                map.put(String.valueOf(i), "Some text for " + i);
//                Thread.sleep(500);
//            }
//        } catch(InterruptedException ex) {
//            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
//        }

        int i = 1;

        try {
            while (true) {
                map.put(""+ i, "Some text for " + i);
                i++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
