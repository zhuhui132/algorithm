package com.leetcode.algorithm.generic;

public class GenericTest {
    public static void main(String[] args) {
        //List<String> list = new ArrayList <>();
        Box<String> boxdemo1 = new Box <>("corn");
        boxdemo1.getData();





    }
}

class Person implements Comparable<Person>{
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString() {
        return this.name + "," + this.score;
    }
}


