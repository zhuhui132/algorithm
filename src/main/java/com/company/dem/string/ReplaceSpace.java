package com.company.dem.string;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
//        if (str == null || str.length()<0){
//            return null;
//        }
//
//
//        int oldStrNum = 0,blankNum = 0;
//
//
//        int i = 0;
//
//        while (i<str.length()){
//            oldStrNum++;
//            if (str.charAt(i)==" "){
//
//            }
//
//        }    }

        String str1 = str.toString();
        String str2 = str1.replace(" ", "%20");
        return str2;
    }

}