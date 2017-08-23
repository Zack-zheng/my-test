package com.zzz.basic.thinginginjava.chapters6;

/**
 * Created by jack_ on 2016/10/21.
 */
//: FinalData.java
// The effect of final on fields
class Value {
    int i = 1;
}

class FinalData {
    // Can be compile-time constants
    final int i1 = 9;
    static final int I2 = 99;
    // Typical public constant:
    public static final int I3 = 39;
    // Cannot be compile-time constants:
    final int i4 = (int) (Math.random() * 20);
    static final int i5 = (int) (Math.random() * 20);
    Value v1 = new Value();
    final Value v2 = new Value();
    static final Value v3 = new Value();
    //! final Value v4; // Pre-Java 1.1 Error:
    // no initializer
    // Arrays:
    final int[] a = {1, 2, 3, 4, 5, 6};

    public void print(String id) {
        System.out.println(
                id + ": " + "i4 = " + i4 +
                        ", i5 = " + i5);
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData();
        //! fd1.i1++; // Error: can't change value
        fd1.v2.i++; // Object isn't constant!
        fd1.v1 = new Value(); // OK -- not final
        for (int i = 0; i < fd1.a.length; i++)
            fd1.a[i]++; // Object isn't constant!
        //! fd1.v2 = new Value(); // Error: Can't
        //! fd1.v3 = new Value(); // change handle
        //! fd1.a = new int[3];
        fd1.print("fd1");
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData();
        fd1.print("fd1");
        fd2.print("fd2");
    }
} ///:~


//: BlankFinal.java
// "Blank" final data members
class Poppet {
}

class BlankFinal {
    final int i = 0; // Initialized final
    final int j; // Blank final
    final Poppet p; // Blank final handle

    // Blank finals MUST be initialized
// in the constructor:
    BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet();
    }

    BlankFinal(int x) {
        j = x; // Initialize blank finalp = new Poppet();
        p = new Poppet();
    }

    public static void main(String[] args) {
        BlankFinal bf = new BlankFinal();
    }
} ///:~


//: FinalArguments.java
// Using "final" with method arguments
class Gizmo {
    public void spin() {
    }
}

class FinalArguments {
    void with(final Gizmo g) {
//! g = new Gizmo(); // Illegal -- g is final
        g.spin();
    }

    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g not final
        g.spin();
    }// void f(final int i) { i++; } // Can't change

    // You can only read from a final primitive:
    int g(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
} ///:~