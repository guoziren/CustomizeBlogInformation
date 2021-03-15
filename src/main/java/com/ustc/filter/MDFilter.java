package com.ustc.filter;

import java.io.File;
import java.io.FileFilter;

public class MDFilter implements FileFilter {
    public boolean accept(File pathname) {
        if (pathname.isDirectory() || pathname.getName().endsWith(".md")) {
            return true;
        } else {
            return false;
        }
    }
}
