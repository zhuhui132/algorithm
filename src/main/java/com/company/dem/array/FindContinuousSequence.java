package com.company.dem.array;

import java.util.ArrayList;

public class FindContinuousSequence {


    public ArrayList <ArrayList <Integer>> FindContinuousSequence(int sum) {

        ArrayList <ArrayList <Integer>> result = new ArrayList <ArrayList <Integer>>();
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if (cur == sum) {
                ArrayList <Integer> list = new ArrayList <Integer>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                plow++;

            } else if (cur < sum) {
                phigh++;
            } else {
                plow++;
            }
        }
        return result;

    }
}