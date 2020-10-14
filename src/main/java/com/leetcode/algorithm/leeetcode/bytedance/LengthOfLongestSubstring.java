package com.leetcode.algorithm.leeetcode.bytedance;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet <>();
        int n = s.length();
        int rk = -1,ans = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0 ){
                occ.remove(s.charAt(i-1));
            }

            while (rk +1 <n&& !occ.contains(s.charAt(rk +1))){
                occ.add(s.charAt(rk+1));
                ++rk;

            }
            ans = Math.max(ans,rk -i+1 );

        }
        return ans;


//
//        //记录当前最大值
//        int result = 0;
//
//        //滑动窗口
//
//        int i = 0;
//        int j = 1;
//
//       while( j <s.length()){
//           // 截取当前i ,j 之间的字符串
//           String resultStr = StringUtils.substring(s, i,j );
//           if (StringUtils.g)
//       }
    }
}