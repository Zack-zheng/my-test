package com.zzz.basic.thinginginjava.chapters7;

/**
 * Created by jack_ on 2016/10/26.
 */
//: Parcel10.java
// Static inner classes

class Parcel10 {
    private static class PContents
            extends Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    protected static class PDestination
            implements Destination {
        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }
    }

    public static Destination dest(String s) {
        return new PDestination(s);
    }

    public static Contents cont() {
        return new PContents();
    }

    public static void main(String[] args) {
        Contents c = cont();
        Destination d = dest("Tanzania");

    }
} ///:~

//: IInterface.java
// Static inner classes inside interfaces
interface IInterface {
    static class Inner {
        int i, j, k;
        public Inner() {}
        void f() {}
    }
} ///:~

//: TestBed.java
// Putting test code in a static inner class
class TestBed {
    TestBed() {}
    void f() { System.out.println("f()"); }
    public static class Tester {
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
} ///:~