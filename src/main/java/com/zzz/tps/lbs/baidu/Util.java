package com.zzz.tps.lbs.baidu;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Jack on 04/05/2016.
 */
public class Util {
    public static void doPOST(NameValuePair[] data, String url) throws Exception {

        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestBody(data);
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

// 设置请求包头文件
//        postMethod.setRequestHeader("Content-Type", "application/json;charset=utf-8");
//        postMethod.setRequestHeader("Content-Length", String.valueOf(requestEntity.getContentLength()));
        int statusCode = 0;
        try {
            //this.doSetProxyForHttpClient(httpClient);//设置代理服务器
            statusCode = httpClient.executeMethod(postMethod);
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(statusCode == 200){
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
                while ((temp = reader.readLine()) != null) {
                    responseString.append(temp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            postMethod.releaseConnection();
            System.out.println(ascii2native(responseString.toString()));
        }else {
            throw  new Exception("请求失败，错误代码为："+ statusCode);
        }


    }
    public static void doGET(String url)  {

        HttpClient client = new HttpClient();
        // 设置代理服务器地址和端口

        //client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
        // 使用 GET 方法 ，如果服务器需要通过 HTTPS 连接，那只需要将下面 URL 中的 http 换成 https
        HttpMethod method=new GetMethod(url);
        //使用POST方法
        //HttpMethod method = new PostMethod("http://java.sun.com");
        try {
            client.executeMethod(method);


        //打印服务器返回的状态
        System.out.println(method.getStatusLine());
        //打印返回的信息
        System.out.println(ascii2native(method.getResponseBodyAsString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放连接
        method.releaseConnection();

    }


    public  static String ascii2native(String asciicode) {
        String[] asciis = asciicode.split("\\\\u");
        String nativeValue = asciis[0];
        try {
            for (int i = 1; i < asciis.length; i++) {
                String code = asciis[i];
                nativeValue += (char) Integer.parseInt(code.substring(0, 4), 16);
                if (code.length() > 4) {
                    nativeValue += code.substring(4, code.length());
                }
            }
        } catch (NumberFormatException e) {
            return asciicode;
        }
        return nativeValue;
    }
}
