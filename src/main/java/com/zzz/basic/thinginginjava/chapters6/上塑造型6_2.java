package com.zzz.basic.thinginginjava.chapters6;

/**
 * Created by jack_ on 2016/10/22.
 */
//: Wind.java
// Inheritance & upcasting

class Instrument {
    public void play() {
    }

    static void tune(Instrument i) {
// ...
        i.play();
    }
}

// Wind objects are instruments
// because they have the same interface:
class Wind extends Instrument {
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute); // Upcasting
    }
} ///:~
/**
 * 这个例子中最有趣的无疑是tune()方法，它能接受一个Instrument 句柄。但在Wind.main()中，tune()方法
 * 是通过为其赋予一个Wind 句柄来调用的。由于Java 对类型检查特别严格，所以大家可能会感到很奇怪，为
 * 什么接收一种类型的方法也能接收另一种类型呢？但是，我们一定要认识到一个Wind 对象也是一个
 * Instrument 对象。而且对于不在Wind 中的一个Instrument（乐器），没有方法可以由tune()调用。在
 * tune()中，代码适用于Instrument 以及从Instrument 衍生出来的任何东西。在这里，我们将从一个Wind 句
 * 柄转换成一个Instrument 句柄的行为叫作“上溯造型”。
 */