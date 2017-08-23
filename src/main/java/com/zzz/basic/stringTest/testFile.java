package com.zzz.basic.stringTest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by jack_ on 2016/3/29.
 */
public class testFile {
    @Test
    public void testFile(){
        String separator = File.separator;
        System.out.println(separator);
        String filename = "myfile.txt";
        String directory = "mydir1" +separator + "mydirl2";
        File f = new File(directory,filename);

        if(f.exists()){
            System.out.println("file name：" + f.getAbsolutePath());
            System.out.println("getParentFile:"+f.getParentFile());
            System.out.println("file size：" + f.length());
        }else {
            f.getParentFile().mkdirs();//create a directory in classpath
            System.out.println(f.getParentFile());
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileList(){
        File f = new File("D:\\cloud\\IdeaProjects\\my-test2");
        tree(f);
    }
    private static void tree(File f) {
        File[] childs = f.listFiles();
        for (int i = 0 ; i<childs.length; i++){
            System.out.println(childs[i].getName());
            if (childs[i].isDirectory()){
                tree(childs[i]);//递归法
            }
        }
    }
}
