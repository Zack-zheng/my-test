package com.zzz.basic.reflect.lesson3;

/**
 * Created by jack_ on 2016/10/6.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*

  @author wblearn
  @date 2016-9-25
 */
public class TestReflection {
    private String name;
    private boolean learn;
    private int[] age;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Class c1 = TestReflection.class;
        Class c2 = Class.forName("com.zzz.basic.reflect.lesson3.TestReflection");
        //获取指定的包名
        String package01 = c1.getPackage().getName();
        String package02 = c2.getPackage().getName();
        System.out.println("package01 = " + package01);
        System.out.println("package02 = " + package02);
        //获取类的修饰符
        int mod = c1.getModifiers();
        String modifier = Modifier.toString(mod);
        System.out.println("modifier = " + modifier);
        //获取指定类的完全限定名
        String className = c1.getName();
        System.out.println("className = " + className);
        //获取指定类的父类
        Class superClazz = c1.getSuperclass();
        String superClazzName = superClazz.getName();
        System.out.println("superClazzName = " + superClazzName);
        //获取实现的接口
        Class[] interfaces = c1.getInterfaces();
        for (Class t : interfaces) {
            System.out.println("interfacesName = " + t.getName());
        }
        //获取指定类的成员变量
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            modifier = Modifier.toString(field.getModifiers()); //获取每个字段的访问修饰符
            Class type = field.getType(); //获取字段的数据类型所对应的Class对象
            String name = field.getName(); //获取字段名
            if (type.isArray()) { //如果是数组类型则需要特别处理
                String arrType = type.getComponentType().getName() +
                        "[]";
                System.out.println("" + modifier + " " + arrType + " "
                        + name + ";");
            } else {
                System.out.println("" + modifier + " " + type + " " +
                        name + ";");
            }
        }
        //获取类的构造方法
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName(); //构造方法名
            modifier = Modifier.toString(constructor.getModifiers()); //获取访问修饰符
            System.out.println("" + modifier + " " + name + "(");
            Class[] paramTypes = constructor.getParameterTypes(); //获取构造方法中的参数
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                if (paramTypes[i].isArray()) {
                    System.out.println(paramTypes
                            [i].getComponentType().getName() + "[]");
                } else {
                    System.out.print(paramTypes[i].getName());
                }
            }
            System.out.println(");");
        }
        //获取成员方法
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            modifier = Modifier.toString(method.getModifiers());
            Class returnType = method.getReturnType(); //获取方法的返回类型
            if (returnType.isArray()) {
                String arrType = returnType.getComponentType
                        ().getName() + "[]";
                System.out.print("" + modifier + " " + arrType + " " +
                        method.getName() + "(");
            } else {
                System.out.print("" + modifier + " " +
                        returnType.getName() + " " + method.getName() + "(");
            }
            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                if (paramTypes[i].isArray()) {
                    System.out.println(paramTypes
                            [i].getComponentType().getName() + "[]");
                } else {
                    System.out.print(paramTypes[i].getName());
                }
            }
            System.out.println(");");
        }
        TestReflection t1 = (TestReflection) c1.newInstance(); //利用反射来创建类的对象
        System.out.println("name == " + t1.name);
        System.out.println("learn == " + t1.learn);
        Method method = c1.getDeclaredMethod("setName", String.class);
        method.invoke(t1, "我是wblearn");
        System.out.println("name == " + t1.name);
        method = c1.getDeclaredMethod("setLearn", boolean.class);
        method.setAccessible(true);
        method.invoke(t1, true);
        System.out.println("learn == " + t1.learn);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLearn() {
        return learn;
    }

    public void setLearn(boolean learn) {
        this.learn = learn;
    }

    public int[] getAge() {
        return age;
    }

    public void setAge(int[] age) {
        this.age = age;
    }
}

