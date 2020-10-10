package com.easy;

import java.util.HashMap;
import java.util.Map;

public class HashTest {
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    public static void main(String[] args) {



        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

//    public boolean tryLock(String key,String request){
//        //private String LOCK_PREFIX;// 锁名称 "redis_lock_"
//        String result = this.jedis.set(LOCK_PREFIX + key, request, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 10 * TIME);
//        if (LOCK_MSG.equals(result)){
//            return true ;
//        }else {
//            return false ;
//        }
//    }
//    }
}
