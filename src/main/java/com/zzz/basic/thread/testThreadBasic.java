package com.zzz.basic.thread;

import org.junit.Test;

import java.util.Date;

/**
 * Created by jack_ on 2016/3/30.
 */
public class testThreadBasic extends Thread {
    @Test//test case 和main启动线程的区别？test case线程终止于new Date()无异常,why?
    public void testCreateThread2() {
        testThreadBasic r = new testThreadBasic();
        r.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread :------" + i);
        }
    }

    public static void main(String[] args) {
        testThreadBasic r = new testThreadBasic();
        r.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread :------" + i);
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runner2:" + i);
            System.out.println(new Date().toString());
        }
    }
}


class CreateThread1 implements Runnable {//实现接口方式创建线程

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Runner1:" + i);
        }
    }

    public static void main(String[] args) {
        CreateThread1 r = new CreateThread1();
//        r.run();// invoke method
        Thread t = new Thread(r);//create a new thread
        t.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main Thread :------" + i);
        }
    }
}

class CreateThread2 extends Thread {//继承类方式创建线程

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Runner1:" + i);
        }
    }

    public static void main(String[] args) {
        CreateThread2 r = new CreateThread2();
        r.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Main Thread :------" + i);
        }
    }
}

class testInterrupt1 extends Thread {
    public void run() {
        Boolean flag = true;
        while (flag) {
            System.out.println("==" + new Date() + "==");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }
    public static void main(String[] args) {
        testInterrupt1 r = new testInterrupt1();
        r.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread :------" + i);
        }
    }
}

class testInterrupt2   {
    public static void main(String[] args) {
        testInterrupt1 r = new testInterrupt1();
        r.start();
        try {
            r.sleep(3000);
            Thread.sleep(4000);//为什么这两个的效果是一样的   有什么区别？
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.interrupt();
    }
}
class testInterrupt3 implements Runnable   {
    public static void main(String[] args) {
        testInterrupt3 r = new testInterrupt3();
        Thread t = new Thread(r);
        t.start();
        try {
            t.sleep(3000);
            Thread.sleep(4000);//为什么这两个的效果是一样的   有什么区别？
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

    public void run() {
        Boolean flag = true;
        while (flag) {
            System.out.println("==" + new Date() + "==");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }
}

class TestJoin extends Thread{
    public static void main(String[] args) {
        TestJoin t = new TestJoin("t");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i  = 1;i<=10;i++){
            System.out.println("i am the main thread");
        }
    }
    public TestJoin(String s) {
        super(s);
    }

    public void run(){
        for (int i = 1; i<=10;i++){
            System.out.println("i am " + getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

class testYield extends Thread {
    public static void main(String[] args) {
        testYield t1 = new testYield("t1");
        testYield t2 = new testYield("t2");
        t1.start();t2.start();
    }
    public testYield(String s) {
        super(s);
    }

    public void run(){
        for (int i = 1; i<= 100;i++){
            System.out.println(getName()+ ": "+i);
            if (i%10 == 0 ){
                yield();
            }
        }
    }
}

class TestPriority extends Thread{
    public static void main(String[] args) {
        TestPriority t1 = new TestPriority("t1");
        TestPriority t2 = new TestPriority("t2");
        t1.setPriority(Thread.NORM_PRIORITY + 3);
        t1.start();t2.start();
    }
    public TestPriority(String s) {
        super(s);
    }
    public void run(){
        for (int i= 0 ; i < 1000 ; i++){
            System.out.println(getName() +": " + i);
        }
    }

}

class TestThread4 extends Thread{//the better way that stop a thread
    public static void main(String[] args) {
        TestThread4 t = new TestThread4();
        t.start();
        for (int i = 0 ; i<100000;i++){
            if (i%10000 == 0 & i>0)
                System.out.println("in thread main i= "+ i);
        }
        System.out.println("Thread main is over");
        System.out.println(Thread.currentThread().isAlive());
        t.shutDown();
        System.out.println(Thread.currentThread().isAlive());
    }
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0 ;
        while (flag == true){
            System.out.println(" " + i++);
        }
    }
    public  void shutDown(){
        flag = false;
    }
}