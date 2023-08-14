package com.yucfeng;

public class SyncMethod {
    synchronized public void method1(){
        System.out.println("线程 "+Thread.currentThread().getName()+"\t调用 method1...");
        method2();
    }
    synchronized public void method2(){
        System.out.println("线程 "+Thread.currentThread().getName()+"\t调用 method2...");
        method3();
    }

    synchronized public void method3(){
        System.out.println("线程 "+Thread.currentThread().getName()+"\t调用 method3...");
    }
}
