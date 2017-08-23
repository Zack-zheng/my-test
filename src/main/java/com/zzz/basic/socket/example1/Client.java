package com.zzz.basic.socket.example1;
import java.io.*;
import java.net.*;
public class Client {
	public Client(int name) {
		try {
			Socket s = new Socket("127.0.0.1", 5432);
			OutputStream out = s.getOutputStream();
			DataOutputStream dout = new DataOutputStream(out);
			dout.writeUTF(Integer.toString(name));
			InputStream in = s.getInputStream();
			DataInputStream din = new DataInputStream(in);
			String st = din.readUTF();
			System.out.println(st);
			in.close();
			out.close();
			s.close();
		} catch (IOException e) {
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Client(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("线程中断");
				e.printStackTrace();
			}
		}
		
	}
}