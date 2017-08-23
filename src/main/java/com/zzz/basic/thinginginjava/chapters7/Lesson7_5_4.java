package com.zzz.basic.thinginginjava.chapters7;

/**
 * Created by jack_ on 2016/10/23.
 */
//: RandVals.java
// Initializing interface fields with
// non-constant initializers

import java.util.*;

interface RandVals {
    int rint = (int) (Math.random() * 10);
    long rlong = (long) (Math.random() * 10);
    float rfloat = (float) (Math.random() * 10);
    double rdouble = Math.random() * 10;
} ///:~

//: TestRandVals.java
class TestRandVals {
    public static void main(String[] args) {
        System.out.println(RandVals.rint);
        System.out.println(RandVals.rlong);
        System.out.println(RandVals.rfloat);
        System.out.println(RandVals.rdouble);
    }
} ///:~