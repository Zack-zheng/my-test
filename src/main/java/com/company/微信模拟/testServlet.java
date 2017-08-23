package com.company.微信模拟;

import java.io.IOException;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import javax.servlet.ServletException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class testServlet {

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
	}

	/**
	 * 用于模拟微信回调
	 * 
	 * @throws IOException
	 * @throws ServletException
	 * */
	@Test
	public void doPost_WXCodeServlet() throws IOException, ServletException {
		System.out.println("service begin");

		// 服务地址
		URL url = new URL("http://localhost:8080/BP/WXCodeServlet");

		// 设定连接的相关参数
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream(), "UTF-8");

		String ins = "orderId=153000045811&reqTime=20150824120728&ext1=&ext2=&merchantId=812440063000916&terminalId=35098613&MAC=";
				System.out.println(ins);
		out.write(ins);
		out.flush();
		out.close();

		// 获取服务端的反馈
		String strLine = "";
		String strResponse = "";
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while ((strLine = reader.readLine()) != null) {
			strResponse += strLine + "\n";
		}
		System.out.print("获取服务端的反馈:" + strResponse);
	}
	@Test
	public void doPost_WXCodeServle1t() throws IOException, ServletException {
		System.out.println("service begin");

		// 服务地址
		URL url = new URL("http://localhost:7444");

		// 设定连接的相关参数
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		OutputStreamWriter out = new OutputStreamWriter(
				connection.getOutputStream(), "GB2312");

		String ins = "<?xml version=\"1.0\" encoding=\"GBK\"?>"+
		"<stream>"+
				"<action>DLBALQRY</action>"+
				"<userName>it10test087</userName><!--登录名varchar(30)-->"+
				"<listname=\"userDataList\">"+
				"<row>"+
				"<accountNo>7323010192000000201</accountNo><!--账号char(19)-->"+
				"</row>"+
				"</list>"+
				"</stream>";
				System.out.println(ins);
		out.write(ins);
		out.flush();
		out.close();

		// 获取服务端的反馈
		InputStreamReader isr = new InputStreamReader(connection.getInputStream(),"GB2312");
		char []cha = new char[1024];
		int len = isr.read(cha);
		System.out.println(new String(cha,0,len));
	}


}
