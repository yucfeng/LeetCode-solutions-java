package com.yucfeng;

import org.junit.Test;

public class Main {

    @Test
    public void testQueue() {
        Solution<Integer> q = new Solution<>();
        CustomQueue<Integer> cq = new CustomQueue<>(2);
        System.out.println(cq.poll());
        cq.add(1);
        cq.add(2);
        cq.add(3);
        System.out.println(cq.poll());
    }

    public static void main(String[] args) {
        new Thread(() -> {
            SyncMethod syncMethod = new SyncMethod();
            syncMethod.method1();
        }, "AAA").start();;

//        int i = Integer.MAX_VALUE;
//        System.out.println(++i);  // -2147483648
//
//        // dead lock
//        Object o1 = new Object();
//        Object o2 = new Object();
//        Thread thread01 = new Thread(() -> {
//            synchronized (o2) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                synchronized (o1) {
//                    System.out.println("A-ok");
//                }
//            }
//        }, "thread01");
//
//        Thread thread02 = new Thread(() -> {
//            synchronized (o1) {
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//                synchronized (o2) {
//                    System.out.println("B-ok");
//                }
//            }
//        }, "thread02");
//        thread01.start();
//        thread02.start();
    }
}