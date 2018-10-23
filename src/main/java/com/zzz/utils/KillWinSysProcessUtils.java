package com.zzz.utils;


import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 杀死win系统进程工具
 * Created by zhengzz on 2018/10/19.
 */
public class KillWinSysProcessUtils {
    public static void main(String[] args) throws Exception {
        killProcess("Xftp.exe", 0);
//        killProcess("java.exe", 60000);
    }
    /**
     *
     * @param targetProcess 映像名称，模糊匹配
     * @param occupyMemoryLimit 占用内存上限，低于此值的进程不会杀掉
     * @throws Exception
     */
    public static void killProcess(String targetProcess, long occupyMemoryLimit) throws Exception {
        List<String> list = executeCommand("tasklist", targetProcess);
        for (String info : list) {
            String[] infoDtls = StringUtils.tokenizeToStringArray(info, " ");
            //占用内存大于60m才杀掉，避免杀死自身进程
            if (Long.parseLong(infoDtls[4].replace(",", "")) > occupyMemoryLimit) {
                executeCommand("taskkill /PID " + infoDtls[1] + " /F", null);
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
