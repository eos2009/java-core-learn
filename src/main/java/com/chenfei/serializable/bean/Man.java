package com.chenfei.serializable.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfei
 * @description
 * @since 2019/10/23
 */
@Data
public class Man extends Person{

    private static final long serialVersionUID = 1L;

    private String moustache;

    private String add;

    @Override
    public String toString() {
        return "Man{" +
                "moustache='" + moustache + '\'' +
                ", sex='" + getSex() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + age +
                ", brithDay='" + getBrithDay() + '\'' +
                '}';
    }
}
