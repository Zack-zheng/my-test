package com.zzz.basic.socket.basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jack_ on 2016/4/6.
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6676);
        while (true){
            Socket s = ss.accept();
            System.out.println("A client connect!");
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
//            if (dis.readUTF()!= null){
                System.out.println(dis.readUTF());
//            }
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF("Hello," + s.getInetAddress()
            +"port#" + s.getPort() + "bye-bye");
            dis.close();
            is.close();
            dos.close();
            os.close();
        }
    }
}
