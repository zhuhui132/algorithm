//package com.algorithm.again;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class Sum90 {
//    private static int totalSum = 0;
//    private static int SCORE = 90;
//
//
//        public static void main (String[]args)
//        {
//            Sum90 cs = new Sum90(10, 90);
//            cs.loop(10);
//            System.out.println(cs.count);
//        }
//
//    public Cs( int times, int score)
//        {
//            this.times = times;
//            this.score = score;
//            loops = new int[times];
//        }
//
//        public void loop ( int cur)
//        {
//            if (cur == 0) {
//                if (score != 0) return;
//                count++;
//                return;
//            }
//            cur--;
//            for (int i = 10; i > 0; i--) {
//                loops[cur] = i;
//                score -= i;   //模拟嵌套for循环
//                loop(cur);
//                score += i;   //状态恢复
//            }
//        }
//    }
//}