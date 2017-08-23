package com.zzz.basic.thinginginjava.chapters6;

/**
 * Created by jack_ on 2016/10/21.
 */
//: Jurassic.java
// Making an entire class final
class SmallBrain {
}

final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();

    void f() {
    }
}

//! class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'
class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
} ///:~