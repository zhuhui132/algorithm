package com.easy;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
//        if(s == null || wordDict == null) return false;
        int n = s.length();

        boolean[] memo = new boolean[n+1];
        memo[0] = true;


        for (int i =1;i<= n;i++){
            for (int j = 0;j<i;j++){
                if (memo[j] && wordDict.contains(s.substring(j,i))){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[0];
    }
}