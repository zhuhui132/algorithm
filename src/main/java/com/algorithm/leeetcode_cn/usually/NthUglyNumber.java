package com.algorithm.leeetcode_cn.usually;

import java.util.Arrays;
import java.util.TreeSet;

public class NthUglyNumber {
    public static void main(String[] args) {
//       int a=  nthUglyNumber(5, 2, 11, 13);
//        System.out.println(a);

        int b=  nthUglyNumber(1000000000,
                2,
                217983653,
                336916467);
        System.out.println(b);
//
//        int c=  nthUglyNumber(3 ,2,     3,  5);
//        System.out.println(c);

        String str = "this is hell world";
        System.out.println(revers(str));
    }
    public  static TreeSet<Integer> set = new TreeSet <>();
    public  static int nthUglyNumber(int n, int a, int b, int c) {
        if(n == 0 ) {
            return  -1  ;
        }
        int[] arrays = new int[]{a,b,c};
        Arrays.sort(arrays);
        int i = 1;
        // 3  2 3 5
        while(i<=n){
             set.add(arrays[0]*i);
             if(set.size() <= n || arrays[0]*n <=arrays[1]) {
                 set.add(arrays[1]*i);
             }
             if(set.size() <= n || arrays[0]*n <=arrays[2]) {
                 set.add(arrays[2]*i);
             }
            i++;
        }
        Object[] demo = set.toArray();
        for (Object demos:demo){
            System.out.println ((int)demos);
        }

        return (int)demo[n-1];
    }

    public static String revers(String str){
        String[] strings = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = strings.length-1;i>0;i--){
            sb.append(strings[i]).append(" ");
            System.out.println(sb.toString());
        }
        sb.append(strings[0]);


        return sb.toString();
    }
}