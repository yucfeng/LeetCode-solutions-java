package com.yucfeng;

public class ThreadInterrupt {

    public static void main(String[] args) {
//        Thread t = new Thread(() -> {
//           while (!Thread.currentThread().isInterrupted()) {
//
//           }
//            System.out.println("t is terminated");
//        });
//
//        System.out.println(Thread.currentThread().isInterrupted());  // false
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.currentThread().isInterrupted());   // true
//
//        System.out.println(Thread.interrupted());  // true
//        System.out.println(Thread.interrupted());  // false

        Thread t2 = new Thread(()-> {
            System.out.println("");
        });
        t2.start();
        t2.start();
    }
}
