package com.zzz.basic.thread;

import com.frames.springJDBC.example1.Test;

/**
 * Created by jack_ on 2016/4/4.
 */
public class testThreadSynchronization {

}

class TestSync implements Runnable{
    Timer timer = new Timer();

    public static void main(String[] args) {
        TestSync test = new TestSync();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.setName("t1");t2.setName("t2");
        t1.start();t2.start();
    }
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}
class Timer{
    private static int num = 0;
    public synchronized void  add(String name){
//        synchronized (this){
            num ++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ",你是第"+ num + "个使用timer的线程");
//        }
    }
}

/**
 * 模拟死锁问题
 */
class TestDeadLock implements Runnable{
    public int flag = 1;
    static Object o1 = new Object(),o2 = new Object();
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1){
            synchronized (o1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }
        if (flag == 0){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        TestDeadLock td1 = new TestDeadLock();
        TestDeadLock td2 = new TestDeadLock();
        td1.flag = 1;td2.flag = 0;
        Thread t1 = new Thread(td1);
        Thread t2 = new Thread(td2);
        t1.start();t2.start();
    }
}


class TT implements Runnable{
    int b = 100;
    public synchronized void m1() throws Exception{
        b = 1000;
        Thread.sleep(800);
        System.out.println("b = " + b );
    }
    public void m2(){
        System.out.println(b);
    }

    public void run(){
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();
        Thread t = new Thread(tt);
        t.start();

        Thread.sleep(1000);
        tt.m2();
    }
}