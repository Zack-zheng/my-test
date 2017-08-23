package com.zzz.basic.reflect.basic;

/**
 * Created by Jack on 07/04/2016.
 */
//1.bootstrap class loader
//    implemented by native language
//    load the core classes of dk
//2.extesion classloader
//    loader the class from jre/lib/ext
//3.application class loader
//    load user-define classes
//    ClassLoader.getSystemClassLoader()
//4.other class locaders
//    SecureClassLoader
//    URLClassLoader
public class TestJDKClassLoader {
    public static void main(String[] args) {
//        System.out.println(String.class.getClassLoader());//got for bootstrap class loader
//        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());//got for extesion classlocader
//        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());//got for application classloader
//        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());

        ClassLoader c = TestJDKClassLoader.class.getClassLoader();
        while (c != null){
            System.out.println(c.getClass().getName());
            c = c.getParent();//有层次关系，但不是继承
            //作用是安全，规范；假设我自己写一个String类，在String里面加一点破坏性的代码，会导致不可预知的结果
        }
    }
}
