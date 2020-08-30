package com.company.dem;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String str1 = str.toString();
        String str2 = str1.replaceAll(" ", "%20");
        return str2;

    }
}
