package com.zzz.basic.thinginginjava.chapters7;

/**
 * Created by jack_ on 2016/10/23.
 * <p/>
 * 常数分组
 * 由于置入一个接口的所有字段都自动具有static 和final 属性，所以接口是对常数值进行分组的一个好工
 * 具，它具有与C 或C++的enum 非常相似的效果。如下例所示：
 */
//: Months.java
// Using interfaces to create groups of constants
interface Months {
    int
            JANUARY = 1, FEBRUARY = 2, MARCH = 3,
            APRIL = 4, MAY = 5, JUNE = 6, JULY = 7,
            AUGUST = 8, SEPTEMBER = 9, OCTOBER = 10,
            NOVEMBER = 11, DECEMBER = 12;
} ///:~

//: Month2.java
// A more robust enumeration system
final class Month2 {
    private String name;

    private Month2(String nm) {
        name = nm;
    }

    public String toString() {
        return name;
    }

    public final static Month2
            JAN = new Month2("January"),
            FEB = new Month2("February"),
            MAR = new Month2("March"),
            APR = new Month2("April"),
            MAY = new Month2("May"),
            JUN = new Month2("June"),
            JUL = new Month2("July"),
            AUG = new Month2("August"),
            SEP = new Month2("September"),
            OCT = new Month2("October"),
            NOV = new Month2("November"),
            DEC = new Month2("December");
    public final static Month2[] month = {
            JAN, JAN, FEB, MAR, APR, MAY, JUN,
            JUL, AUG, SEP, OCT, NOV, DEC
    };

    public static void main(String[] args) {
        Month2 m = Month2.JAN;
        System.out.println(m);
        m = Month2.month[12];
        System.out.println(m);
        System.out.println(m == Month2.DEC);
        System.out.println(m.equals(Month2.DEC));
    }
} ///:~