package com.leetcode.algorithm.leeetcode.june;

import java.util.HashMap;
import java.util.Map;

public class GetFolderNames {
    public String[] getFolderNames(String[] names) {
        String[] arr = new String[names.length];
        if (names.length == 0 || names == null) return arr;

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])){
                arr[i] = names[i];
                map.put(names[i],1 );
            }
            else {
                int count = map.get(names[i]);
                while (map.containsKey(names[i] + "(" + count + ")")) {
                    count++;
                }
                map.put(names[i] + "(" + count + ")", 1);
                map.put(names[i], map.get(names[i])+1);
                // 本次的结果
                arr[i] = names[i] + "(" + count + ")";


            }
        }
        return arr;
    }
}
