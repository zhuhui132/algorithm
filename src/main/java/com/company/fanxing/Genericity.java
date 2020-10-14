package com.company.fanxing;

import java.util.ArrayList;
import java.util.List;

//定义的泛型类，就一定要传入泛型类型实参么？
//        并不是这样，在使用泛型的时候如果传入泛型实参，
//        则会根据传入的泛型实参做相应的限制，
//        此时泛型才会起到本应起到的限制作用。
//        如果不传入泛型类型实参的话，
//        在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
public class Genericity {
    public static void main(String[] args) {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
//传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic <Integer> genericInteger = new Generic <Integer>(123456);

//传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic <String> genericString = new Generic <String>("key_vlaue");
//        Log.d("泛型测试","key is " + genericInteger.getKey());
//        Log.d("泛型测试","key is " + genericString.getKey());


    }


    public void oneExample() {
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String) arrayList.get(i);
            //Logger("泛型测试","item = " + item);
        }
    }






}

//泛型 类
class Generic<T> {
    private T key;

    /**
     * 泛型的类型参数只能是类类型，不能是简单类型。
     * 不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
     *
     * @param key
     */
    public Generic(T key) {
        this.key = key;
    }

    public T getKey() { //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
}

