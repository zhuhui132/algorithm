package com.leetcode.algorithm.again;

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
//        isSubsequence.isSubsequence("abc", "ahbgdc");
        System.out.println(isSubsequence.isSubsequence("a", "c"));
    }

    public boolean isSubsequence(String s, String t) {
        char[] arr = s.toCharArray();
        int j = -1;
        for(int i = 0;i<arr.length;i++) {
            j = t.indexOf(arr[i],j+1);
            if(j==-1) {
                return false;
            }
        }
        return true;
    }
}


//        if (s.length() == 0) return true;
//        char[] charsOfS = s.toCharArray();
//        char[] charsOfT = t.toCharArray();
//        int index = t.indexOf(charsOfS[0]);
//        if (index == -1){
//            return false;
//        }
//        for (int i = 1; i < charsOfS.length; i++) {
//            if (t.indexOf(charsOfS[i]) <= index) {
//                return false;
//
//            } else {
//                index = t.indexOf(charsOfS[i]);
//            }
//        }
//
//        return true;
//    }
//}