package com.zzz.basic.stringTest;

import org.junit.Test;

/**
 * Created by jack_ on 2016/3/18.
 */
 public class testString {
    @Test
    public  void testindexof1(){
        String s = "aldadoifjavaadlfiaddlakfjava";
        String toFind = "java";
        int count = 0;
        int index = -1;

        while ((index = s.indexOf(toFind)) != -1){;
            s = s.substring(index + toFind.length());
            count ++;
        }
        System.out.println(count);
    }
    @Test
    public  void testindexof2(){
        String s = "aldadoifjavaa;dlfiaddlakfjava";
        String toFind = "java";
        int count = 0;
        int index = -1;

        while (s.indexOf(toFind) != -1){
            s = s.substring(index + toFind.length());
            System.out.println(s);
        }
    }

    @Test
    public  void testArrayParser(){
        double [][] d;
        String s = "1,2;3,4,5;6,7,8";
        String [] sFirst = s.split(";");
        d = new double[sFirst.length][];
        for(int i = 0; i< sFirst.length ; i++){
            String [] sSecond = sFirst[i].split(",");
            d[i] = new double[sSecond.length];
            for(int j = 0; j<sSecond.length ; j++){
                d[i][j] = Double.parseDouble(sSecond[j]);
            }
        }

        for (int i = 0 ;i<d.length ; i++){
            for(int j = 0 ; j<d[i].length;j++){
                System.out.println(d[i][j] + " ");

            }
            System.out.println();
        }

    }


    public enum MyColor {red, green, blue}
    @Test
    public  void testEnum(){
        MyColor m = MyColor.red;
        switch (m){
            case red:
                System.out.println("red");
                break;
            case green:
                System.out.println("green");
                break;
            default:
                System.out.println("default");

        }
        System.out.println(m);
    }

    @Test
    public  void testMath(){
        double a = Math.random();
        double b = Math.random();
        System.out.println(Math.sqrt(a*a+b*b));
        System.out.println(Math.pow(a,8));
        System.out.println(Math.round(b));
        System.out.println(Math.log(Math.pow(Math.E,15)));
        double d = 60.0, r = Math.PI/4;
        System.out.println(Math.toRadians(d));
        System.out.println(Math.toDegrees(r));
    }




}
