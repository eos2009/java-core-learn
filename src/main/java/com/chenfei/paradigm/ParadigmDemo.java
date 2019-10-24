package com.chenfei.paradigm;

import com.chenfei.paradigm.bean.Bounded;
import com.chenfei.paradigm.bean.UnBounded;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfei
 * @description 泛型学习,java实现的为伪泛型
 * 泛型作用
 *      类型安全、消去强制类型转换（防止类型转换异常ClassCastException）
 * 泛型实现原理
 *      类型擦除（在编译器层实现；使用泛型加上的类型参数，编译器会在编译的时候去掉，这个过程称为“类型擦除”（type erasure），
 *                即编译的class文件不包含泛型的类型信息）
 *                原始类型都会被自动地提供。类型变量被擦除（crased），并使用其限定类型（无限定的变量用Object）替换。
 *      类型擦除java实现，编译器先检查代码中泛型类型，然后类型擦除，再进行编译
 *
 *      类型检查就是针对引用的，谁是一个引用，用这个引用调用泛型方法，就会对这个引用调用的方法进行类型检测，而无关它真正引用的对象。
 *
 *      原始类型：原始类型（raw type）就是擦除去了泛型信息，最后在字节码中的类型变量的真正类型。
 *
 *      限定类型：如<T extends Number> 使用Number替换
 *      不限定类型：<T>使用Object替换
 *
 * @since 2018/10/25
 */
public class ParadigmDemo {
    public static void main(String[] args) throws Exception{

        //test1();
        // 通配符
        List<String> listString = new ArrayList<String>();
        listString.add("hello");
        test4(listString);
        List<Integer> listInteger = new ArrayList<Integer>();
        listInteger.add(111);
        test4(listInteger);

    }

    /**
     * 测试泛型类，new多个实例，内存中类型Class是一个
     *      结果：泛型类在内存中只存在一个基础类型 Class
     *      原因：在于Java中的泛型这一概念提出的目的，
     *            导致其只是作用于代码编译阶段，在编译过程中，对于正确检验泛型结果后，
     *            会将泛型的相关信息擦出，也就是说，成功编译过后的class文件中是不包含任何泛型信息的。
     *            泛型信息不会进入到运行时阶段。
     */
    private static void test1(){
        UnBounded<String> name = new UnBounded<String>("corn");
        UnBounded<Integer> age = new UnBounded<Integer>(712);
        System.out.println("name class:" + name.getClass());
        System.out.println("age class:" + age.getClass());
        System.out.println(name.getClass() == age.getClass());
    }

    /**
     * 限定类型 只能为Number的子类，否则编译报错
     */
    private static void test2(){
        //Bounded<String> name = new Bounded<String>("corn");
        Bounded<Integer> age = new Bounded<Integer>(712);
    }

    /**
     * 验证泛型擦除
     *      使用非限定类型(UnBounded)可以正常运行
     *      使用限定类型(Bounded) 运行保错 java.lang.NoSuchMethodException: com.chenfei.paradigm.bean.Bounded.setData(java.lang.Object)
     * @throws Exception
     */
    private static void test3() throws Exception{
        UnBounded<Integer> age = new UnBounded<Integer>(712);
        //Bounded<Integer> age = new Bounded<Integer>(712);
        age.getClass().getMethod("setData",Object.class).invoke(age,"hello");
        // 打印信息为“hello”  证明泛型擦除后只剩原始类型
        System.out.println(age.getData());
    }

    /**
     * 泛型方法（通配符）
     * @param list
     * @throws Exception
     */
    private static void test4(List<?> list) throws Exception{
        for(Object o:list){
            System.out.println(o);
        }
    }







}
