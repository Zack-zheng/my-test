package com.zzz.tools.mytest;

import org.junit.Test;

import java.math.BigDecimal;

public class testString {
	@Test
	public void test1(){
		String orderAmount = "864070";
		StringBuffer sb = new StringBuffer();

//		orderAmount = orderAmount.substring(0, orderAmount.length()-2)+"."+orderAmount.substring(orderAmount.length()-2);
//		System.out.println(orderAmount);
		sb.append(orderAmount.substring(0, orderAmount.length()-2)).append(".").append(orderAmount.substring(orderAmount.length()-2));
		System.out.println(sb.toString());
	}
	@Test
	public void test2(){
		String orderAmount = "864070";
		orderAmount = new BigDecimal(orderAmount).divide(new BigDecimal(100),2, BigDecimal.ROUND_HALF_UP).toString();
		System.out.println(orderAmount);
	}
	public static void main(String[] args) {
		String errr ="1";
		String errrinfo ="2";
		String orderid ="3";
		String no ="4";
		String form = "X-X-X-X";
		String[] predx = form.split("X");
		String message = "";

		int i = 1;
		message = errr + predx[i++] + errrinfo + predx[i++] + orderid
				+ predx[i++] + no;
		System.out.println(message);
	}

}
