package com.zzz.basic.thinginginjava.chapters7;

/**
 * Created by jack_ on 2016/10/29.
 */
//: InheritInner.java
// Inheriting an inner class
class WithInner {
    class Inner {
        Inner(){
            System.out.println("super inner class");
        }
    }
}

class InheritInner
        extends WithInner.Inner {
    //! InheritInner() {} // Won't compile
    InheritInner(WithInner wi) {
        wi.super();
        System.out.println("subclass");
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
} ///:~