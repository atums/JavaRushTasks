package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/* 
Что внутри папки?
*/
public class Solution {

    static int sumFolder = -1;
    static int sumFile;
    static long volueDir;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path dir = Paths.get(reader.readLine());
        reader.close();

        if(!Files.isDirectory(dir)) {
            System.out.println(dir.toAbsolutePath().toString() + " - не папка");
//            System.exit(0); // Странно почему не приняло такое решение вместо return
            return;
        }
        Files.walkFileTree(dir, new myVisitior());

        System.out.println("Всего папок - " + sumFolder);
        System.out.println("Всего файлов - " + sumFile);
        System.out.println("Общий размер - " + volueDir);
    }
    public static class myVisitior extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            sumFolder += 1;
            return CONTINUE;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            sumFile += 1;
            volueDir += attrs.size();
            return CONTINUE;
        }
    }
}
