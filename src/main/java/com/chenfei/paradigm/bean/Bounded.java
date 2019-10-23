package com.chenfei.paradigm.bean;

/**
 * @author chenfei
 * @description 类型边界
 *          上边界（T extends E）：类及其子类类型的数据
 *          下边界（T super E）：类及其父类类型的数据
 * @since 2018/10/25
 */
public class Bounded<T extends Number> {
    private T data;

    public Bounded(){}

    public Bounded(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}