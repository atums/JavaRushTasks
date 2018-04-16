package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();

        try {
            Thread.sleep(450);
            while(!currentThread.isInterrupted()) {
                ShareItem item = queue.take();
                System.out.format("Processing " + item.toString() + "\n");
            }
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }


    }
}
