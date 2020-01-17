package com.algorithm.java8;

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


        List<Apple> list2 = findApple(list,new GreenAppleFilter());
        System.out.println(list2);


        List<Apple> list3 = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return (apple.getColor().equals("green") && apple.getWeight()>=150);

            }
        });
    }
    public static List<Apple> findGreenApple(List<Apple> apples){
        List<Apple> list = new ArrayList<>();
        for (Apple apple:apples) {
            if (apple.getColor().equals("green")) {
                list.add(apple);
            }
        }
        return list;
    }


    public static List<Apple> findApple(List<Apple> apples,AppleFilter appleFilter){
        List<Apple> list = new ArrayList<>();
        for (Apple a :apples) {
            if (appleFilter.filter(a)){
                list.add(a);
            }
        }
        return list;
    }



    public interface AppleFilter{
        boolean filter(Apple apple);
    }


    public static class GreenAppleFilter implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight()>=150);
        }
    }


}
