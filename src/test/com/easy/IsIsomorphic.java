package com.easy;

import com.leetcode.algorithm.again.Ha;

import java.util.HashMap;

public class IsIsomorphic {
    public static void main(String[] args) {
        IsIsomorphic isIsomorphic =  new IsIsomorphic();
        isIsomorphic.isIsomorphic("egg","aadd");
    }
// s = "egg", t = "add"
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }
}


//egg add   add egg
//        //foo bar   bar foo
//        HashMap<Character, Integer> s1 = new HashMap<>();
//        HashMap<Character, Integer> s2 = new HashMap<>();
//        Boolean result = true;
//        for (int i = 0; i < s.length(); i++) {
//            if (s1.get((Character)s.charAt(i)) == null  && s2.get((Character)t.charAt(i)) == null
//                    || s1.get(s.charAt(i)) == s2.get(t.charAt(i))) {
//                s1.put((Character )s.charAt(i),s1.getOrDefault(s.charAt(i),0)+1);
//                s2.put((Character )t.charAt(i),s1.getOrDefault(t.charAt(i),0)+1);
//            } else {
//                result = false;
//                break;
//            }
//        }
//        System.out.println(result);
//        return result;
//
//    }
//}