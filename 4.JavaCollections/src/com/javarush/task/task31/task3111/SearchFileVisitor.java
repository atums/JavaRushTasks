package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = null;
    private String partOfContent = null;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new LinkedList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        byte[] content = Files.readAllBytes(file); // размер файла: content.length

//        if(file.getFileName().toString().contains(partOfName)) {
//            foundFiles.add(file);
//        } else if(Files.readAllLines(file).toString().contains(partOfContent)) {
//            foundFiles.add(file);
//        } else if(attrs.size() > minSize ) {
//            foundFiles.add(file);
//        } else if(attrs.size() < maxSize) {
//            foundFiles.add(file);
//        }

//---
//        if(file.getFileName().toString().contains(partOfName) && Files.readAllLines(file).toString().contains(partOfContent) && attrs.size() > minSize && attrs.size() < maxSize) {
//            foundFiles.add(file);
//        }
//---


////------
        boolean isFitWithFilter = true;

        if(partOfName!=null&&isFitWithFilter){
            isFitWithFilter = file.getFileName().toString().contains(partOfName);
        }
        if(partOfContent!=null&&isFitWithFilter){
            isFitWithFilter = Files.readAllLines(file).toString().contains(partOfContent);
        }
        if(minSize>=0&&isFitWithFilter){
            isFitWithFilter = attrs.size()>minSize;
        }
        if(maxSize>=0&&isFitWithFilter){
            isFitWithFilter = attrs.size()<maxSize;
        }

        if(isFitWithFilter) foundFiles.add(file);
////------

        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
