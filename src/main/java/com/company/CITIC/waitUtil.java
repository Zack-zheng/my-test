package com.company.CITIC;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jack on 13/04/2016.
 */
public class waitUtil {
    public static String sendMessage(String request) {
        try {
            // 服务地址
            URL url = new URL("http://127.0.0.1:7444");
//            URL url = new URL("http://127.0.0.1:8888");

            // 设定连接的相关参数
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream(), "GB2312");

            System.out.println("request message: \n" + request);
            out.write(request);
            out.flush();
            out.close();

            // 获取服务端的反馈
            String strLine = "";
            InputStream in = connection.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            InputStreamReader isr = new InputStreamReader(
                    connection.getInputStream(), "GB2312");
            char[] cha = new char[65535];
            int len = isr.read(cha);
            String response = new String(cha, 0, len);
            isr.close();
            in.close();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 通过Console读一行输入．
     *
     * @return
     */

    public static String readLine() {
        int ch;
        String r = "";
        boolean done = false;
        while (!done) {
            try {
                ch = System.in.read();
                if (ch < 0 || (char) ch == '\n') {
                    done = true;
                } else if ((char) ch != '\r') {
                    r = r + (char) ch;
                }
            } catch (java.io.IOException e) {
                done = true;
            }

        }
        return r;
    }

    public static void sendClient(String xml) {
        System.out.println("response message : \n" + sendMessage(xml));
    }
}
