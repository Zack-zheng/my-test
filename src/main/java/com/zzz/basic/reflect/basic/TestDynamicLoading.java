package com.zzz.basic.reflect.basic;

/**
 * Created by Jack on 07/04/2016.
 */
public class TestDynamicLoading {
    public static void main(String[] args) {
        new A();
        System.out.println("**---------------------------**");
        new B();

        new C();
        new C();

        new D();
        new D();
    }
}

class A{

}

class B{

}
class C{
    static {
        System.out.println("CCCCCCCCCCCCCCCCCCCCCC");

    }
}

class D{
//    D(){m();}
//    public void m()
    {//动态语句块，每次新建对象都会load,使用效果和构造函数里面调用方法一样
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDD");
    }
}