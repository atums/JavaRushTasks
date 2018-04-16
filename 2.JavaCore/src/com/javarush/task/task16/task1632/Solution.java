package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());

    }

    public static void main(String[] args) {
        for(int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }
//        threads.get(1).interrupt();

    }

    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            while(true) {

            }
        }
    }
    public static class ThreadTwo extends Thread {

        @Override
        public void run() {
            try {
//                Thread current = Thread.currentThread();
//                while(!current.isInterrupted()) {
//                    if(current.isInterrupted()) {
//                        break;
//                    }
//
//                }
                Thread.sleep(10);

            } catch(InterruptedException ex) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            while(true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class ThreadFour extends Thread implements Message {
        boolean closeIt = false;
        @Override

        public void run() {
            while(closeIt == false) {
                showWarning();
            }
        }

        @Override
        public void showWarning() {
//            Thread current = Thread.currentThread();
            closeIt = true;
        }
    }
    public static class ThreadFive extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String closeIt = null;
            int result = 0;
            while(true) {
                try {
                    closeIt = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    if(closeIt.equals("N")) {
                        break;
                    }
                    result += Integer.parseInt(closeIt);

            }
            System.out.println(result);
        }
    }
}