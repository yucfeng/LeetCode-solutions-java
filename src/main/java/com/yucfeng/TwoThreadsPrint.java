package com.yucfeng;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadsPrint {

    static volatile int n =0;
    static final Object lock = new Object();

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(() -> {
            while (n<101) {
                synchronized (lock) {
                    while (n%2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + n);
                    n++;
                    lock.notifyAll();
                }
            }
        });
        threadPool.submit(() -> {
            while (n<100) {
                synchronized (lock) {
                    while (n%2 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + n);
                    n++;
                    lock.notifyAll();
                }
            }
        });
    }
}
