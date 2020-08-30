package com.leetcode.algorithm.leeetcode.usually;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyHashSet {
    int [] data = null;
    public MyHashSet() {
        data = new int[1000001];
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
    }

    public void add(int key) {
        data[key] = key;
    }

    public void remove(int key) {
        data[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[key] == -1? false : true;
    }
}
