package com.zzz.basic.io;

import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * Created by jack_ on 2016/3/24.
 */
public class testStream {
    //节点流 inputstream outputstream reader writer
    @Test
    public void testFileInputstream(){
        int b = 0;
        FileInputStream in = null;

        try {
            in = new FileInputStream("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java");//ctrl + shift +c for get file system location
        } catch (FileNotFoundException e) {
            System.out.print("找不到指定文件");
            System.exit(-1);
        }
        try {
            long num = 0;
            while ((b = in.read())!=-1){
                System.out.print((char)b);
                num ++;
            }
            in.close();
            System.out.println();
            System.out.println("共读取了 " + num + " 个字节");
        } catch (IOException e) {
            e.printStackTrace();System.exit(-1);
        }


    }
    @Test
    public void testFileOutputstream(){
        int b = 0;
        File directory = new File("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java");//设定为当前文件夹
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            System.out.println(directory.getAbsoluteFile());
            in = new FileInputStream(directory.getAbsolutePath());
            out = new FileOutputStream(directory.getAbsolutePath()+"1");
            while ((b = in.read()) != -1){
                out.write(b);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("文件复制错误");
            System.exit(-1);
        }
        System.out.println("文件复制成功");

    }

    //处理流
    @Test
    public void testFileReader(){
        FileReader fr = null;
        int c = 0 ;
        try {
            fr = new FileReader("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java");
            int ln = 0 ;
            while ((c = fr.read())!= -1){
                System.out.print((char)c);
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testFileWriter(){
        FileWriter fw = null;

        try {
            fw = new FileWriter("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java2");
            for (int c = 0;c<=5000;c++){
                fw.write(c);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入错误");
            System.exit(-1);

        }
    }

    //缓存流
    @Test
    public void testBufferInputStream(){
        try {
            FileInputStream fis = new FileInputStream("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java");
            BufferedInputStream bis = new BufferedInputStream(fis);
            int c = 0 ;
            System.out.print((char)bis.read()+" \n");
            System.out.print((char)bis.read()+" \n");
            bis.mark(100);//做个标记，以便于reset，好像没有什么用
            for (int i = 0 ; i<=10&&(c = bis.read())!=-1;i++){
                System.out.print((char)c + " ");
            }
            System.out.println();
            bis.reset();
            for (int i  = 0 ;i <= 10 &&(c=bis.read())!=-1;i++){
                System.out.print((char)c + " ");
            }
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBufferOutputStream(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java3"));
            BufferedReader br = new BufferedReader(new FileReader("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java3"));
            String s = null ;
            for (int i =1;i<=100;i++){
                s = String.valueOf(Math.random());
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            while ((s = br.readLine())!=null){
                System.out.println(s);
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //转换流
    @Test
    public void testTransForm1(){
        try {
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java4"));
            osw.write("mircosoftibmsunapplehp");
            System.out.println(osw.getEncoding());
            osw.close();
            osw = new OutputStreamWriter(new FileOutputStream("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java4",false),"ISO8859_1");// boolean append
            osw.write("mircosoftibmsunapplehp");
            System.out.println(osw.getEncoding());
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        try {
            s=br.readLine();
            while (s!= null){
                if (s.equalsIgnoreCase("exit")) break;
                System.out.println(s.toUpperCase());
                s= br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //数据流（字节数组流）
    @Test
    public void testDataStream(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeDouble(Math.random());
            dos.writeBoolean(true);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            System.out.println(bais.available());
            DataInputStream dis  = new DataInputStream(bais);
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //print 流
    @Test
    public void testPrintStream(){
        PrintStream ps = null ;
        try {
            FileOutputStream fos = new FileOutputStream("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java5");
            ps = new PrintStream(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(ps != null){
            System.setOut(ps);//设置输出管道指向ps
        }
        int ln = 0 ;
        for (char c =0;c<=60000;c++){
            System.out.print(c + " ");
            if(ln ++ >= 100)
            {
                System.out.println();
                ln = 0;
            }
        }

    }

    @Test
    public void testPrintStrea(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java"));
            String s = null;
            PrintStream fs =System.out;
            while ((s = br.readLine())!= null){
                fs.print(s);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPrintStream3(){//放在main方法中才能执行
        String s = null;
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        try {
            FileWriter fw = new FileWriter("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java6",true);
            PrintWriter log = new PrintWriter(fw);
            while ((s = br.readLine())!= null){
                if (s.equalsIgnoreCase("exit")) break;
                System.out.println(s.toUpperCase());
                log.print("------");
                log.print(s.toUpperCase());
                log.flush();
            }
            log.println("==="+new Date()+"===");
            log.flush();
            log.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testObjectIO(){
        T t = new T();
        t.k = 8;
        try {
            FileOutputStream fos = new FileOutputStream("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java7");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(t);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("D:\\cloud\\IdeaProjects\\my-test2\\src\\com\\zzz\\io\\testStream.java7");
            ObjectInputStream ois = new ObjectInputStream(fis);
            T tReaded = (T) ois.readObject();
            System.out.println(tReaded.i + " "+tReaded.j + " " +tReaded.d+ " "+ tReaded.k );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

class T implements Serializable
{
    int i = 10;
    int j = 9;
    double d =2.3;
    transient int k = 15;//透明化的，在序列化的时候不写
}