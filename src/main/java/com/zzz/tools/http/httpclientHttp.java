package com.zzz.tools.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * @author Jack_zheng
 *使用my-test/src/commons-httpclient-3.1.jar
 *
 */
public class httpclientHttp {
	public static void main(String[] args) {
		NameValuePair[] data = { 
				new NameValuePair("OrderDate", "jkwhe912eu9"),
				new NameValuePair("OrderTime", "jkwhe91e1212e1e2eu9"),
				new NameValuePair("CurrencyCode", "jkwhe9121e12e12e12efeu9"), 
				new NameValuePair("OrderNo", "jkwhe9121e12e12e12efeu9"), 
				new NameValuePair("OrderAmount", "jkwhe9121e12e12e12efeu9"), 
				new NameValuePair("OrderDesc", "jkwhe9121e12e12e12efeu9"), 
				new NameValuePair("cardNo", "jkwhe9121e12e12e12efeu9"), 
				new NameValuePair("ResultNotifyURL", "jkwhe9121e12e12e12efeu9"), 
				new NameValuePair("ProductName", "jkwhe9121e12e12e12efeu9"), };
		doHttpResponse(data ,"http://localhost:8080/postABCToPayment/redirectToQilian.do");
	}

	public static void doHttpResponse(NameValuePair[] data, String url) {

		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestBody(data);
		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
		
		
		int statusCode = 0;
		try {
			//this.doSetProxyForHttpClient(httpClient);//设置代理服务器
			statusCode = httpClient.executeMethod(postMethod);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream resInputStream = null;
		try {
			resInputStream = postMethod.getResponseBodyAsStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//解析数据
		BufferedReader reader = new BufferedReader(new InputStreamReader(resInputStream));
		String temp = null; //读取字符流转化的字符串
		StringBuffer responseString = new StringBuffer();
		try {
			while((temp = reader.readLine()) != null){
				responseString.append(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(responseString.toString() );

	}

}
