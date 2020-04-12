package com.algorithm.leeetcode_cn.hot100;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList <>();
     //   List<Integer> result = new ArrayList <>();
        for (int i = 0;i<candidates.length;i++){
            int times = target / candidates[i];
            int low = target %candidates[i];

            for (int j: candidates) {
                List<Integer> result = new ArrayList <>();
                if (j== low){
                    for (int k = 0;k<times;k++){
                        result.add(candidates[i]);
                    }
                    result.add(low);
                }
                if (result.size() != 0){
                    list.add(result);
                }
            }

        }
       return list;
    }
}