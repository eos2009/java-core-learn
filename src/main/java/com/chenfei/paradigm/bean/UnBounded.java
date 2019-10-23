package com.chenfei.paradigm.bean;

/**
 * @author chenfei
 * @description
 * @since 2018/10/25
 */
public class UnBounded<T> {

    private T data;

    public UnBounded(){}

    public UnBounded(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
