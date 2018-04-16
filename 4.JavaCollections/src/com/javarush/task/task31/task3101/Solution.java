package com.javarush.task.task31.task3101;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
//    // Я хз, что еще нужно у меня все работает сраный Валидатор - Результат тот же, что и у проходящего валидацию!!!
//    public static void main(String[] args) {
////        File path = new File(args[0]);
////        File resultFileAbsolutePath = new File(args[1]);
//        File path = new File("e:\\!!!\\"); //
//        File resultFileAbsolutePath = new File("e:\\!.txt"); //
//
//        File allFilesContent = new File(resultFileAbsolutePath.getParentFile() + "/allFilesContent.txt");
//
//        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
//
//        File[] files = path.listFiles();
//        Arrays.sort(files);
//        try(FileOutputStream fos = new FileOutputStream(allFilesContent)) {
//            for(File file : files) {
//                if(file.length() <= 50) {
//                    String str;
//                    BufferedReader br = new BufferedReader(new FileReader(file));
//                    while((str = br.readLine()) != null) {
//                        str += "\n";
//                        fos.write(str.getBytes());
//                    }
//                    br.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static TreeSet<File> Lower50 = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        for (String s : args)
            System.out.println(s);
        File path = new File(args[0]); //Путь к директории
        File resultFileAbsolutePath = new File(args[1]); //Файл с контекстом всех файлом <50
//        File path = new File("e:\\!!!\\"); //
//        File resultFileAbsolutePath = new File("e:\\!.txt"); //


        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        //хз верно ли указывать в конструкторе "allFilesContent", а не "resultFileAbsolutePath"
        //но валидатор принимает, а во втором варианте - нет
        try (FileOutputStream fos = new FileOutputStream(allFilesContent)) {

            deepSearch(path);
            TreeMap<String, File> fileAndPath = new TreeMap<>();
            for (File f : Lower50)
                fileAndPath.put(f.getName(), f);
            for (Map.Entry<String, File> pair : fileAndPath.entrySet()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(pair.getValue()));
                String s = "";
                while ((s = bufferedReader.readLine()) != null)
                    fos.write((s + "\n").getBytes());
                // fos.write("\n".getBytes());
                bufferedReader.close();
            }
        } catch (IOException e) {

        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void deepSearch(File f) {
        if (f.isDirectory()) {
            for (File ff : f.listFiles()) {
                deepSearch(ff);
            }
        } else if (f.isFile()) {
            if (f.length() > 50)
                FileUtils.deleteFile(f);
            else
                Lower50.add(f);
        }
    }

}
