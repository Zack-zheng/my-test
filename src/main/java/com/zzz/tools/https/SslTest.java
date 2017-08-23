package com.zzz.tools.https;

/**
 * Created by zhengzz on 2017/8/21.
 */

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.commons.io.IOUtils;

import javax.net.ssl.*;

/**
 * 这样做是放弃了证书的认证，但是会使得https失去意义
 * 就好像搭建了一个https的server，最后在认证失败的时候放弃认证，
 * 直接选择信任，那么这个https的server就沦落为一个http的server了，
 * 而且性能要比http差
 * 本客户端不建议用于生产，可用于手工工具之类的
 */
public class SslTest {
    public String getRequest(String url, int timeOut) throws Exception {
        URL u = new URL(url);
        if ("https".equalsIgnoreCase(u.getProtocol())) {
            ignoreSsl();
        }
        URLConnection conn = u.openConnection();
        conn.setConnectTimeout(timeOut);
        conn.setReadTimeout(timeOut);
        return IOUtils.toString(conn.getInputStream());
    }

    public String postRequest(String urlAddress, String args, int timeOut) throws Exception {
        URL url = new URL(urlAddress);
        if ("https".equalsIgnoreCase(url.getProtocol())) {
            ignoreSsl();
        }
        URLConnection u = url.openConnection();
        u.setDoInput(true);
        u.setDoOutput(true);
        u.setConnectTimeout(timeOut);
        u.setReadTimeout(timeOut);
        OutputStreamWriter osw = new OutputStreamWriter(u.getOutputStream(), "UTF-8");
        osw.write(args);
        osw.flush();
        osw.close();
        u.getOutputStream();
        return IOUtils.toString(u.getInputStream());
    }

    public static void main(String[] args) {
        try {
            SslTest st = new SslTest();
            String a = st.getRequest("https://10.64.4.6:7643/FinanceRepayService/web/financeTest/statusChangeToApp", 3000);
            System.out.println(a);
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 忽略HTTPS请求的SSL证书，必须在openConnection之前调用
     *
     * @throws Exception
     */
    public static void ignoreSsl() throws Exception {
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                return true;
            }
        };
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

    private static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[1];
        TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }

    static class miTM implements TrustManager, X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType)
                throws CertificateException {
            return;
        }
    }
}
