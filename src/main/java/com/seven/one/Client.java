package com.seven.one;

public class Client {
    public static void main(String[] args) {
        try {
            Class componentClass = Class.forName("com.seven.one.UpperCaseComponent");


            if (componentClass.isAnnotationPresent(Component.class)) {
                Component component = (Component) componentClass.getAnnotation(Component.class);
                String identifier = component.identifer();
                System.out.println(String.format("Identifier for " + "com.jasongj.UpperCaseComponent is ' %s '", identifier));
            } else {
                System.out.println("com.jasongj.UpperCaseComponent is not annotated by" + " com.jasongj.annotation.Component");
            }
        } catch ( ClassNotFoundException ex ) {
            ex.printStackTrace();
        }
    }
}
//Annotation与Interface的异同
//Annotation类型使用关键字@interface而非interface。注意开头的@符号
//Annotataion的方法定义是受限制的。其方法必须声明为无参数、无异常抛出的。这些方法同时也定义了Annotation的成员——方法名即为成员名，而方法返回类型即为成员类型。方法返回类型必须为Java基础类型、Class类型、枚举类型、Annotation类型或者相应的一维数组。方法后面可以使用default关键字和一个默认数值来声明成员的默认值，null不能作为成员默认值。成员一般不能是泛型，只有当其类型是Class时可以使用泛型，因为此方法能够用类型转换将各种类型转换为Class
// Annotation和interface都可以定义常量、静态成员类型。interface可以被实现或者继承，Annotation不可以
