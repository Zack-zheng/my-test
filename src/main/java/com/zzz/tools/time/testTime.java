package com.zzz.tools.time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class testTime {
	public static void main(String[] args) {
		//Timestamp
		//2015-09-11 04:00:02.0
		Timestamp d = new Timestamp(System.currentTimeMillis());
		System.out.println(new Timestamp(d.getTime()-1000*60*60*24));
		String date = new SimpleDateFormat("yyyyMMdd").format(/*message.getInitTime()*/d).toString();
		
	}
}
