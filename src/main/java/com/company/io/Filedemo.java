package com.company.io;

import java.io.File;

public class Filedemo {
    public static void main(String[] args) {
        String fileName = "D:" + File.separator + "ID";

        File file = new File(fileName);


        if (file.exists() && file.isDirectory()) {
            System.out.println("文件夹");

            File[] files = file.listFiles();

            for (File s : files) {
                System.out.println(s);
            }
            System.out.println();
            System.out.println("files[0]的文件名：" + files[0].getName());
            System.out.println("files[0]的文件名：" + files[0].getAbsolutePath());
        }




    }


    public void testFile() {
        File file = new File("D:\\testData.txt");
    }
}
