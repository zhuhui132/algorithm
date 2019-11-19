package com.demo.nowcode;

public class ReplaceSpace {
    public static void main(String[] args) {

    }


    public String replaceSpace(StringBuffer str){
        String result = str.toString().replace(" ", "%20");
        return result;

    }
}
