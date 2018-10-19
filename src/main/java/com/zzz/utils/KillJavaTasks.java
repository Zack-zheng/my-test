package com.zzz.utils;


import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzz on 2018/10/19.
 */
public class KillJavaTasks {
    public static void main(String[] args) throws Exception {

        List<String> list = executeCommand("tasklist", "java.exe");
        for (String info : list) {
            String[] infoDtls = StringUtils.tokenizeToStringArray(info, " ");
            //占用内存大于60m才杀掉，避免杀死自身进程
            if (Long.parseLong(infoDtls[4].replace(",", "")) > 60000) {
                executeCommand("taskkill /PID " + infoDtls[1]+ " /F", null);
            }
        }
    }

    public static List<String> executeCommand(String command, String filterProcessName) throws Exception {
        System.out.println("执行命令:" + command);
        List<String> taskInfos = new ArrayList<>();
        Process process = Runtime.getRuntime().exec(command);
        InputStream is = process.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line;
        while ((line = reader.readLine()) != null) {
            if (filterProcessName == null || line.contains(filterProcessName)) {
                taskInfos.add(line);
            }
        }
        process.waitFor();
        is.close();
        reader.close();
        process.destroy();
        return taskInfos;
    }

}
