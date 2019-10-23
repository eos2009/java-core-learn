package com.chenfei.serializable.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfei
 * @description
 * @since 2019/10/23
 */
@Data
public class Person implements Serializable{

    private String sex;
    private String name;
    public static int age = 18;
    transient private String brithDay;

    @Override
    public String toString() {
        return "Person{" +
                "sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", brithDay='" + brithDay + '\'' +
                '}';
    }
}
