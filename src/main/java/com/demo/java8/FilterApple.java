package com.demo.java8;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green",150),
                new Apple("green",150),
                new Apple("1green",150),
                new Apple("2green",150));


        List<Apple> greenApple = findGreenApple(list);
        assert greenApple.size() == 2;
        System.out.println(greenApple);
    }
    public static List<Apple> findGreenApple(List<Apple> apples){
        List<Apple> list = new ArrayList<>();
        for (Apple apple:apples) {
            if (apple.getColor().equals("green"))
            list.add(apple);
        }
        return list;
    }


}
