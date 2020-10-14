package com.Lambda;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaDem {

    /**
     * 刚接触Lambda表达式可能觉得它很神奇：
     * 不需要声明类或者方法的名字，
     * 就可以直接定义函数。这看似是编译器为匿名内部类简写提供的一个小把戏，
     * 但事实上并非如此，
     * Lambda表达式实际上是通过invokedynamic指令来实现的。先别管这么多，
     * 下面是Lambda表达式几种可能的书写形式，“看起来”并不是很难理解。
     *
     * @param args
     */
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("heell world");
        ActionListener listener = event -> System.out.println("");

        Runnable multiline = () -> {
            System.out.println("");
            System.out.println("he");
        };

        BinaryOperator <Long> add = (Long x, Long y) -> x + y;// 4
        BinaryOperator <Long> addImplicit = (x, y) -> x + y;// 5
    }

//Lambda表达式一个常见的用法是取代（某些）匿名内部类，但Lambda表达式的作用不限于此。

    public void threadOld() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread");
            }

            ;
        }).start();
    }


    public void threadLamBda() {
        new Thread(() -> System.out.println("new Thrd")).start();
    }

//假设需要从一个字符串列表中选出以数字开头的字符串并输出，Java 7之前需要这样写：

    public void example1() {
        List <String> list = Arrays.asList("1one", "two", "three", "4four");
        for (String str : list) {
            if (Character.isDigit(str.charAt(0))) {
                System.out.println(str);
            }
            ;
        }

/**
 * 上述代码首先1. 调用List.stream()方法得到容器的Stream，
 * 2. 然后调用filter()方法过滤出以数字开头的字符串，
 * 3. 最后调用forEach()方法输出结果。
 *
 * 使用Stream有两个明显的好处：
 */

        list.stream()//1.得到容器的Steam
                .filter(str -> Character.isDigit(str.charAt(0)))// 2.选出以数字开头的字符串
                .forEach(str -> System.out.println(str)); //3.输出字符串
    }

    //假设需要从一个字符串列表中，选出所有不以数字开头的字符串，将其转换成大写形式，并把结果放到新的集合当中。Java 8书写的代码如下：
    public void example2(){
        List<String> list = Arrays.asList("1one", "two", "three", "4four");
        List<String> newList = new ArrayList <>();


        for (String str:list){
            if (!Character.isDigit(str.charAt(0))){
                str.toUpperCase();
                newList.add(str);
            }
        }

//        1. 调用List.stream()方法得到容器的Stream，
//        2. 然后调用filter()方法选出不以数字开头的字符串，
//        3. 之后调用map()方法将字符串转换成大写形式，
//        4. 最后调用collect()方法将结果转换成Set。这个例子还向我们展示了方法引用（method references，代码中标号3处）以及收集器（
//        Collector，代码中标号4处）的用法，这里不再展开说明。
//
//        通过这个例子我们看到了Stream链式操作，
//        即多个操作可以连成一串。不用担心这会导致对容器的多次迭代，
//        因为不是每个Stream的操作都会立即执行。
//        Stream的操作分成两类，一类是中间操作(intermediate operations)，
//        另一类是结束操作(terminal operation)，只有结束操作才会导致真正的代码执行，
//        中间操作只会做一些标记，表示需要对Stream进行某种操作。
//        这意味着可以在Stream上通过关联多种操作，
//        但最终只需要一次迭代。如果你熟悉Spark RDD，对此应该并不陌生。
        Set<String> set = list.stream()
                .filter(str->!Character.isDigit(str.charAt(0)))
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

    }

}


