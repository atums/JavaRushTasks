package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger atomicInteger = new AtomicInteger(1);

    public MyThread() {
//        atomicInteger.getAndIncrement();
        if(atomicInteger.get() < 10) {
            setPriority(atomicInteger.getAndIncrement());
        } else {
            setPriority(atomicInteger.get());
            atomicInteger.set(1);
        }
    }

    public MyThread(Runnable target) {
        super(target);
        if(atomicInteger.get() < 10) {
            setPriority(atomicInteger.getAndIncrement());
        } else {
            setPriority(atomicInteger.get());
            atomicInteger.set(1);
        }
//        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if(atomicInteger.get() < 10) {
            setPriority(atomicInteger.getAndIncrement());
        } else {
            setPriority(atomicInteger.get());
            atomicInteger.set(1);
        }
//        super(group, target);
    }

    public MyThread(String name) {
        super(name);
        if(atomicInteger.get() < 10) {
            setPriority(atomicInteger.getAndIncrement());
        } else {
            setPriority(atomicInteger.get());
            atomicInteger.set(1);
        }
//        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if(atomicInteger.get() < 10) {
            setPriority(atomicInteger.getAndIncrement());
        } else {
            setPriority(atomicInteger.get());
            atomicInteger.set(1);
        }
//        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if(atomicInteger.get() < 10) {
            setPriority(atomicInteger.getAndIncrement());
        } else {
            setPriority(atomicInteger.get());
            atomicInteger.set(1);
        }
//        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if(atomicInteger.get() < 10) {
            setPriority(atomicInteger.getAndIncrement());
        } else {
            setPriority(atomicInteger.get());
            atomicInteger.set(1);
        }
//        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if(atomicInteger.get() < 10) {
            setPriority(atomicInteger.getAndIncrement());
        } else {
            setPriority(atomicInteger.get());
            atomicInteger.set(1);
        }
//        super(group, target, name, stackSize);
    }
}
