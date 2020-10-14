package com.leetcode.algorithm.generic;

public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
//    public T getFirst() { ... }
//    public T getLast() {. .. }

    // 对静态方法使用<T>:
    public static<K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}