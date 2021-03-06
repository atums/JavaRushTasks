package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String[] arch = f.getName().split(".");
        if(f.isDirectory()) {
            return true;
            } else {
                if(f.getName().toLowerCase().endsWith(".htm") || f.getName().toLowerCase().endsWith(".html")) {
                    return true;
                }
            }
        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
