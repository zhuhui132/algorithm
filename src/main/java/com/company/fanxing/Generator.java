package com.company.fanxing;

//泛型接口
//
//泛型接口与泛型类的定义及使用基本相同。泛型接口常被用在各种类的生产器中，可以看一个例子：
interface Generator<T>{
    public T next();
}