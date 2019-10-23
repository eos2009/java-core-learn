package com.chenfei.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenfei
 * @description
 * @since 2018/10/29
 */

public class Main {

    public static void main(String[] args) throws Exception{
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);

        trackUseCase2s(PasswordUtils.class);
}

    public static void trackUseCases(List<Integer> useCases, Class<?> cl) throws Exception{

        System.out.println(cl.getDeclaredAnnotations().length);
        for(Annotation annotation : cl.getAnnotations()){
            System.out.println(annotation.annotationType().getName());
        }

        System.out.println(cl.getClass());

        System.out.println(cl.getClassLoader());

        System.out.println(cl.getDeclaredMethods().length);
        System.out.println(cl.getMethods().length);
        for(Method method : cl.getDeclaredMethods()){
            System.out.println(method.getName());
        }
        for(Method method : cl.getMethods()){
            System.out.println(method.getName());
        }


        System.out.println(cl.getDeclaredFields().length);
        System.out.println(cl.getFields().length);

        System.out.println(cl.getDeclaredField("salt").getName());
        //System.out.println(cl.getField("salt").getName());

        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " "
                        + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void trackUseCase2s(Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase2 uc = m.getAnnotation(UseCase2.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.value() + " "
                        + uc.description());
            }
        }
    }
}
