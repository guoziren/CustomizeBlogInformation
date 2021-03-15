package com.ustc.blob.util;

import sun.rmi.runtime.Log;

import java.io.*;

public class FileUtil {
    private static final String TAG = "FileUtil";
    public static String readFile(File file) {
        if (file == null || file.isDirectory()) {
            System.out.println("[debug] file does not exit or file is directory");
            return "";
        }
        System.out.println(file.getAbsolutePath() + ":");
        char[] buffer = new char[1024];
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            int len = 0;
            while ((len = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void processFile(File file) {
        if (file == null) {
           LogUtil.d(TAG, "processFile: file is empty" );
        }
        // 1.读文件
        String content = readFile(file);
        // 2.
        int headBegin = content.indexOf("---");
        if (headBegin == -1) {
            // 没有 --- , Todo
            return;
        }
        int headEnd = content.indexOf("---", headBegin + 3);
        String substring = content.substring(headBegin + 3, headEnd);
        // 3.修改title
        String name = file.getName();

        // 4.修改tag
        System.out.println("--- 中间内容为 --- :" + substring);
    }
}
