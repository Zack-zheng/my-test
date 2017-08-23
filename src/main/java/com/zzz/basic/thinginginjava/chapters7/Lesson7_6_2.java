package com.zzz.basic.thinginginjava.chapters7;

/**
 * Created by jack_ on 2016/10/25.
 */
//: Contents.java
//: Wrapping.java

class Wrapping {
    private int i;

    public Wrapping(int x) {
        i = x;
    }

    public int value() {
        return i;
    }
} ///:~

//: Parcel4.java
// Nesting a class within a method
class Parcel4 {
    public Destination dest(String s) {
        class PDestination
                implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Destination d = p.dest("Tanzania");
    }
} ///:~


//: Parcel5.java
// Nesting a class within a scope
class Parcel5 {
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
// Can't use it here! Out of scope:
//! TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() {
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        p.track();
    }
} ///:~

//: Parcel6.java
// A method that returns an anonymous inner class
class Parcel6 {
    public Contents cont() {
        return new Contents() {
            private int i = 11;

            public int value() {
                return i;
            }
        }; // Semicolon required in this case
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        Contents c = p.cont();
    }
} ///:~

//: Parcel7.java
// An anonymous inner class that calls the
// base-class constructor

class Parcel7 {
    public Wrapping wrap(int x) {
// Base constructor call:
        return new Wrapping(x) {
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Wrapping w = p.wrap(10);
    }
} ///:~

//: Parcel8.java
// An anonymous inner class that performs
// initialization. A briefer version
// of Parcel5.java.
class Parcel8 {
    // Argument must be final to use inside
// anonymous inner class:
    public Destination dest(final String dest) {
        return new Destination() {
            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Destination d = p.dest("Tanzania");
    }
} ///:~

//: Parcel9.java
// Using "instance initialization" to perform
// construction on an anonymous inner class
class Parcel9 {
    public Destination
    dest(final String dest, final float price) {
        return new Destination() {
            private int cost;

            // Instance initialization for each object:
            {
                cost = Math.round(price);
                if (cost > 100){
                    System.out.println("Over budget!");
                }
            }

            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.dest("Tanzania", 101.395F);
    }
} ///:~