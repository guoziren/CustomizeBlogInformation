package com.ustc;

import com.ustc.blob.util.FileUtil;
import com.ustc.filter.MDFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\project\\personal\\CustomizeBlogInformation\\src\\main\\resources";
        scan(path);
    }

    private static void scan(String path) {
        File root = new File(path);
        if (root == null || !root.isDirectory()) {
            // 必须是目录
            return;
        }
        List<File> mdList = new ArrayList<File>();
        FindAllMDFileAndAddToList(root,mdList);
        System.out.println(mdList);
        processMDFiles(mdList);
    }

    private static void processMDFiles(List<File> mdList) {
        for (File file : mdList) {
            FileUtil.processFile(file);
        }
    }

    /**
     * 找出root目录下的所有md文件加入到集合中
     * @param root
     * @param mdList
     */
    private static void FindAllMDFileAndAddToList(File root, List<File> mdList) {
        if (root.isFile()) {
            mdList.add(root);
            return;
        }
        File[] files = root.listFiles(new MDFilter());
        if (files == null) {
            return;
        }
        for (File file : files) {
            FindAllMDFileAndAddToList(file, mdList);
        }
    }
}
