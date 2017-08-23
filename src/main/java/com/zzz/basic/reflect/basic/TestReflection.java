package com.zzz.basic.reflect.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jack_ on 2016/4/10.
 */
public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String str = "com.zzz.basic.reflect.basic.T";
        Class c = Class.forName(str);
        Object o = c.newInstance();//新建对象
        Method[] methods =  c.getMethods();//取得所有方法
            for (Method m :methods){
            System.out.println(m.getName());
            if (m.getName().equals("m")){
                m.invoke(o,1,1);//调用方法,参数为2个
                //invoke(java.lang.Object obj,java.lang.Object... args)
            }
            if(m.getName().equals("mm")){
                m.invoke(o);//调用方法，无参数
            }
            if(m.getName().equals("getS")){
                Class returnType = m.getReturnType();
                System.out.println("returnType" + returnType.getName());
            }
        }

    }
}

class T {
    static {
        System.out.println("T loaded!");
    }
    int i;

    public T(){
        System.out.println("T constructed!");
    }
    String s;
    public void m1(int i){
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void m(int i ,int j ){
        System.out.println("i+j == "+i+j);
        System.out.println("m invoked!");
    }

    public void mm(){
        System.out.println("mm invoked!");
    }
}
