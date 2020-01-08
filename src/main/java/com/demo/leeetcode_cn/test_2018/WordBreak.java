//package com.demo.leeetcode_cn.test_2018;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class WordBreak {
//    public static void main(String[] args) {
////        String s= "catsandog";
////        List<String> list = new ArrayList <>();
////       // ["cats","dog","sand","and","cat"]
////        list.add("cats");
////        list.add("dog");
////        list.add("sand");
////        list.add("and");
////        list.add("cat");
//
//
//        String s= "leetcode";
//        List<String> list = new ArrayList <>();
//        // ["cats","dog","sand","and","cat"]
//        list.add("leet");
//        list.add("code");
//        WordBreak wordBreak = new WordBreak();
//       Boolean result =  wordBreak.wordBreak(s,list );
//        System.out.println(result);
//
//    }
//    public boolean wordBreak(String s, List <String> wordDict) {
//        String repalceStr =s;
//        if (s.length()==0 ||wordDict.size()==0) return false;
//
//        return wordBreak2(s,wordDict );
//    }
//
//    public boolean wordBreak2(String s, List <String> wordDict){
//        String repalceStr;
//        Boolean tem = true;
//        //for (String str : wordDict) {
//        for (int i = 0;i<wordDict.size();i++){
//            if (tem ==false)break;
//            if (s.indexOf(wordDict.get(i)) == -1) {
//                tem=false;
//            }else {
//                repalceStr =s.replace(wordDict.get(i),"");
//                tem= wordBreak2(repalceStr,wordDict);
//            }
//
//        }
//        return tem;
//    }
//
//
//    public boolean wordBreak3(String s, List <String> wordDict){
//        String repalceStr;
//        Boolean tem = true;
//        //for (String str : wordDict) {
//        for (String ss: wordDict) {
//           if (){
//
//           }
//        }
//        return tem;
//    }
//
//
//
//
//
//
//}