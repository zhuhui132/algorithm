package com.algorithm.thread.base.chapter1;


public class TryConcurrenty {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            println("task  i-" + i);
//        }
//
//        println(Thread.currentThread().getName());
//
//        for (int j = 0; j < 100; j++) {
//            println("task  j-" + j);
//        }
        try {
            Thread.sleep(1000 * 300L);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        readFromDataBase();
        wirteDataToFile();

    }


    private static void readFromDataBase() {
        // read data from database
        try {
            println("Begin read data from db");
            Thread.sleep(1000 * 10L);
            println("done read data from db");
        } catch ( InterruptedException e ) {
            e.printStackTrace();
            ;
        }

        println("finsh");


    }


    private static void wirteDataToFile() {
        try {
            println("Begin wirteDataToFile  from db");
            Thread.sleep(2000 * 10L);
            println("done wirteDataToFile  from db");
        } catch ( InterruptedException e ) {
            e.printStackTrace();
            ;
        }

        println(" wirteDataToFile finsh");


    }

    private static void println(String message) {
        System.out.println(message);
    }
}
