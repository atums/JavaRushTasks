package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();

        try {
            for(int i = 1; i < 10; i++) {
                if(!currentThread.isInterrupted()) {
                    System.out.format("Элемент 'ShareItem-%s' добавлен%n", i);
                    queue.offer(new ShareItem("ShareItem-" + i, i));
                    Thread.sleep(100);

                    if(queue.hasWaitingConsumer()) {
                        System.out.format("Consumer в ожидании!%n");
                    }
                } else {
                    break;
                }
            }
        } catch(Exception ex) {

        }


//        currentThread.stop();
    }
}