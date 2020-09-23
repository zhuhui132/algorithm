package com.middle;

import java.util.HashSet;
import java.util.Set;

public class NumKLenSubstrNoRepeats {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length(); // 字符串的长度
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ane = 0;  // 左索引、右索引、长度为 K 的无重复字符子串的数目
        while (i < n && j < n) {
            //检查最后一个字符是否在set中
            if (!set.contains(s.charAt(j))) {
                // 不在，则j后移，扩展set窗口
                set.add(s.charAt(j));
                j++;
            } else {
                //在的话i后移减小set窗口，注意此时 j 所在的字符还没加入
                set.remove(s.charAt(i));
                i++;
            }

            //如果窗口的大小为k，则找到符合要求的一个字串
            if (set.size() == k) {
                ane++;
                // 统计好了后左指针字符删除，并且往右走一步
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ane;
    }
}
