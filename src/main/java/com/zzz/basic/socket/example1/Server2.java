package com.zzz.basic.socket.example1;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ServerSocket s = null;
        try{
            s= new ServerSocket(5432);
        }
        catch(IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
        int i = 1;
        while(true)
        {
            
            try{
                Socket cs = s.accept();
                new ServerThread(cs).start();
                System.out.println("接收了 第"+i+"个请求");
                i++;
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
    }

}