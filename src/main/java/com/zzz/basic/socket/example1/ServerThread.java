package com.zzz.basic.socket.example1;

import java.io.*;
import java.net.*;

public class ServerThread extends Thread {
	static String hello = "From Server: Hello world！";
	Socket sock;

	public ServerThread(Socket s) {
		sock = s;
	}

	public void run() {
		try {
			InputStream in = sock.getInputStream();
			DataInputStream din = new DataInputStream(in);
			String name = din.readUTF();
			OutputStream out = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF(hello + "your name :" + name);
			in.close();
			out.close();
			sock.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}