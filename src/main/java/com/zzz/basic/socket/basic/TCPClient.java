package com.zzz.basic.socket.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by jack_ on 2016/4/6.
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        int i=0;
        while (true){
            Socket s = new Socket("127.0.0.1",6676);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            String outputString =""+i++;
            dos.writeUTF(outputString);
            DataInputStream dis = new DataInputStream(s.getInputStream());
//            if (dis.readUTF()!= null){
                System.out.println(dis.readUTF());
//            }
            dos.flush();
            dos.close();

            dis.close();
            s.close();
            Thread.sleep(1000);
        }


    }
}
