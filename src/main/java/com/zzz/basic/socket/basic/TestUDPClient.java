package com.zzz.basic.socket.basic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * Created by jack_ on 2016/4/6.
 */
public class TestUDPClient {
    public static void main(String[] args) throws IOException {
        byte[] buf = (new String("Hello")).getBytes();
        DatagramPacket dp = new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",5678));
        DatagramSocket ds = new DatagramSocket(9999);
        ds.send(dp);
        ds.close();
    }
}
