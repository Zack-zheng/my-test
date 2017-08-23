package com.zzz.tools.http;

import com.zzz.tools.string.StringUtils;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

/**
 * Created by jack_ on 2017/8/20.
 */
public class HttpClient {
    /**
     * @param url  请求地址
     * @param data 键值对数组
     * @throws Exception
     */
    public static String httpPost(String url, NameValuePair[] data) throws Exception {
        System.out.println("请求地址：" + url);
        PostMethod postMethod = new PostMethod(url);
        postMethod.setRequestBody(data);
        org.apache.commons.httpclient.HttpClient httpClient = new org.apache.commons.httpclient.HttpClient();
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

        int statusCode = httpClient.executeMethod(postMethod);
        if (statusCode == 200) {
            InputStream resInputStream = postMethod.getResponseBodyAsStream();

            //解析数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(resInputStream));
            String temp; //读取字符流转化的字符串
            StringBuffer responseString = new StringBuffer();
            while ((temp = reader.readLine()) != null) {
                responseString.append(temp);
            }
            return responseString.toString();
        } else {
            throw new IOException("请求失败，返回码：" + statusCode);
        }
    }

    /**
     * @param uri            请求地址
     * @param nameValuePairs 键值对数组
     * @return 请求结果
     * @throws Exception
     */
    public static String httpGet(String uri, NameValuePair[] nameValuePairs) throws Exception {
        if (StringUtils.isBlank(uri)) {
            throw new Exception("请求资源地址不允许为空");
        }
        org.apache.commons.httpclient.HttpClient myclient = new org.apache.commons.httpclient.HttpClient();
        StringBuffer sb = new StringBuffer();
        sb.append(uri);

        if (!StringUtils.isEmpty(nameValuePairs)){
            int length = nameValuePairs.length;
            for (int i = 1; i <= length; i++) {
                NameValuePair nameValuePair = nameValuePairs[i - 1];
                if (length == i) {
                    sb.append(nameValuePair.getName()).append("=").append(URLEncoder.encode(nameValuePair.getValue(), "utf-8"));
                } else {
                    sb.append(nameValuePair.getName()).append("=").append(URLEncoder.encode(nameValuePair.getValue(), "utf-8")).append("&");
                }
            }
        }
        System.out.println("uri为：" + sb.toString());
        // 构建http客户端
        GetMethod myGet = new GetMethod(sb.toString()); // 加密端口
        int returnFlag = myclient.executeMethod(myGet); // 获得http返回码
        // 打印结果页面
        if (returnFlag == 200) {
            String result = myGet.getResponseBodyAsString();
            return result;
        }
        throw new HttpException("http错误:" + returnFlag);
    }

    public static void main(String[] args) throws Exception {

        System.out.println(httpGet("https://sp0.baidu.com/5a1Fazu8AA54nxGko9WTAnF6hhy/su?wd=&json=1&p=3&sid=1458_19034_12897_21113_18559_20698_20929&req=2&sc=eb&csor=0&cb=jQuery11020695697750027767_1503222727648&_=1503222727650",null));
    }
}
