package com.zzz.test.my_test;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WatchUtils {
    final static String code = "RTpc6L+F6Zu35LiL6L29XEF1dG9DQURfMjAxOF94NjRfTGl0ZV9MaWJyYXJ5XFNldHVwQ29u";
    private final static List<String> FILE_SUF = Arrays.asList("Lk1QNA==", "LkdJRg==", "Lk1PVg==", "LnJtdmI=", "LmF2aQ==", "Lm0zdTg=");

    public static void main(String[] args) {
//        mainProc(code,true);
        mainProc(code, false);
    }


    public static void mainProc(String code, boolean needMatch) {
        File outer = new File(new String(Base64.decodeBase64(code)));
        for (File inner : Objects.requireNonNull(outer.listFiles())) {
            if (inner.isDirectory()) {
                mainProc(Base64.encodeBase64String(inner.getAbsolutePath().getBytes()), needMatch);
                continue;
            }

            if (FILE_SUF.stream().anyMatch(a -> inner.getName().toLowerCase().endsWith(new String(Base64.decodeBase64(a)).toLowerCase())) || !needMatch) {
                boolean result = inner.renameTo(new File(inner.getParent() + File.separator + new StringBuilder(inner.getName()).reverse()));
                if (!result) {
                    System.out.println("error");
                }
            }
        }
    }


}
