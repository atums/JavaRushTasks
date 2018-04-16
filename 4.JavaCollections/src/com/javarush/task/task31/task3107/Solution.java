package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path pathFile = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(pathFile), Files.isExecutable(pathFile), Files.isDirectory(pathFile), Files.isWritable(pathFile));
        } catch(Exception ex) {
            fileData = new NullFileData(ex);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
