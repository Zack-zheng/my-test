package com.zzz.basic.io.Serializable;

import java.io.*;

/**
 * Created by jack_ on 2016/3/11.
 */
public class Cat implements Serializable{
    private String name ;
    public Cat(){
    this.name = "new cat";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        try {
            FileOutputStream fos = new FileOutputStream("catDemo.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("1>"+cat.getName());
            cat.setName("My Cat");
            oos.writeObject(cat);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("catDemo.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            cat = (Cat)ois.readObject();
            System.out.println("2+" + cat.getName());
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
