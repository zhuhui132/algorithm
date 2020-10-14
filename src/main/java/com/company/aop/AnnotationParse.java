package com.company.aop;

import java.lang.reflect.Method;

public class AnnotationParse {


    public static String privilegeParse(Method method) throws Exception {


        if (method.isAnnotationPresent(Permission.class)) {
            Permission annotation = method.getAnnotation(Permission.class);
            return annotation.authorities();
        }
        return null;
    }
}