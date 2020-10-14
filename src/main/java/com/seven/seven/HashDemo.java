package com.seven.seven;

import java.util.Map;

public class HashDemo {
    public static void main(String[] args) {

    }


    //    由于Key的哈希值的分布直接决定了所有数据在哈希表上的分布或者说决定了哈希冲突的可能性，
//    因此为防止糟糕的Key的hashCode实现（例如低位都相同，只有高位不相同，与2^N-1取与后的结果都相同），
//    JDK 1.7的HashMap通过如下方法使得最终的哈希值的二进制形式中的1尽量均匀分布从而尽可能减少哈希冲突。
    public static int hightestOneBit(int i) {
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 19);
//        i |= (i>>1);
        return i - (i >> 1);

    }


//    public void transfer(Map.Entry[] newTable, boolean rehash) {
//        int newCapacity = newTable.length;
//
//
//        for (Map.Entry e : newTable) {
//            while (null != e) {
//                Map.Entry <K, V> next = e.next;
//                if (rehash) {
//                    e.hash = null == e.key ? 0 : hash(e.key);
//                }
//                int i = indexFor(e.hash, newCapacity);
//                e.next = newTable[i];
//                newTable[i] = e;
//                e = next;
//            }
//        }
//    }
}