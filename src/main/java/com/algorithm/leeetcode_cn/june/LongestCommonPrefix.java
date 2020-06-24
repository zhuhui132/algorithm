package com.algorithm.leeetcode_cn.june;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix  = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));


    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String ans = strs[0];

        for (int i = 0;i<strs.length;i++){
            int j = 0;
            for (;j<ans.length()&& j<strs[i].length();j++){
                if (ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }

            }
            ans = ans.substring(0,j);
            if (ans.equals("")){
                break;
            }
        }
        return ans;
    }
    public List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> ans = new ArrayList <>();
        if (S.length() < 3) return  ans;

        for (int i = 0; i < S.length(); i++) {
            int j = i;
            while (j<S.length() && S.charAt(i) ==S.charAt(j)){
                j++;
            }

            if ( 3 < j-i){
                List<Integer> temp = new ArrayList <>();
                temp.add(i);
                temp.add(j-1);
                ans.add(temp);
            }
            i = j;
        }
        return ans;
    }



}




