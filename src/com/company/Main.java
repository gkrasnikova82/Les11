package com.company;
//1) Написать программу, которая будет создавать, переименовывать, копировать и удалять файл.
//
//2) Написать рекурсивный обход всех файлов и подкаталогов внутри заданного каталога.

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class Filewalker {

    public void walk(String path) {

        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath());
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        File f1 = new File("C://SomeDir//Hello.txt");// обьявили переменную f1.
        f1.delete();// удалене существующего файла
        try {
            boolean file = f1.createNewFile();//создаем файл
        } catch (IOException e) {
            e.getMessage();
        }
        File f2 = new File("C://SomeDir//Goodbay.txt");//объявии переменную 2
        f2.delete();
        if (f1.renameTo(f2)) {//изменяем наименование файла
            System.out.println("Rename succesful");
        } else {
            System.out.println("Rename failed");
        }
        File f3 = new File("C://SomeDir//Fale1.txt");
        f3.delete();
        Files.copy(f2.toPath(), f3.toPath());// копируем файл
        Filewalker fw = new Filewalker();
        fw.walk("C://SomeDir");
        f2.delete();
    }
}

