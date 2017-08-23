package com.zzz.basic.thread;

/**
 * Created by jack_ on 2016/4/5.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);//限制是生产和消费者消费生产窝头的数量要一样多，否则会发生
        new Thread(p).start();
        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();
    }
}

class ProducerConsumermultiple {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Producer p1 = new Producer(ss);
        Producer p2 = new Producer(ss);
        Consumer c1 = new Consumer(ss);
        Consumer c2 = new Consumer(ss);
        new Thread(p1).start();
//        new Thread(p2).start();
//        new Thread(p2).start();
        new Thread(c1).start();
        new Thread(c2).start();
//        new Thread(c).start();
//        new Thread(c).start();
    }
}

class WoTou {//窝头
    int id;

    WoTou(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WoTou{" + "id=" + id + '}';
    }
}

class SyncStack {//篮子
    int index = 0;
    WoTou[] arrWT = new WoTou[6];

    public synchronized void push(WoTou wt) {
        while (index == arrWT.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        arrWT[index] = wt;
        index++;
    }

    public synchronized WoTou pop() {
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        index--;
        return arrWT[index];
    }
}

class Producer implements Runnable {//生产者
    SyncStack ss = null;

    Producer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 60; i++) {
            WoTou wt = new WoTou(i);
            ss.push(wt);
            System.out.println("生产了: " + wt);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {//消费者
    SyncStack ss = null;

    Consumer(SyncStack ss) {
        this.ss = ss;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            WoTou wt = ss.pop();
            System.out.println("消费了： "+wt);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

