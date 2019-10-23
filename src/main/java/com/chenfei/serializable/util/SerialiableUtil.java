package com.chenfei.serializable.util;

import com.chenfei.serializable.bean.Man;
import com.chenfei.serializable.bean.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author chenfei
 * @description
 * @since 2019/10/23
 */
public class SerialiableUtil {

    public static void serialiablePerson() throws Exception{
        Person person = new Person();
        person.setName("张三");
        person.setSex("男");
        person.setBrithDay("2010-11-20");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/person.ser"));
        objectOutputStream.writeObject(person);
        System.out.println("Person对象序列化成功");
        objectOutputStream.close();
    }

    public static Person deserialiablePerson() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/person.ser"));
        Person person = (Person) objectInputStream.readObject();
        System.out.println("Person对象反序列化成功");
        objectInputStream.close();
        return person;
    }

    public static void serialiableMan() throws Exception{
        Man man = new Man();
        man.setName("张三");
        man.setSex("男");
        man.setBrithDay("2010-11-20");
        man.setMoustache("有胡子");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/man.ser"));
        objectOutputStream.writeObject(man);
        System.out.println("Man对象序列化成功");
        objectOutputStream.close();
    }

    public static Man deserialiableMan() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/man.ser"));
        Man man = (Man) objectInputStream.readObject();
        System.out.println("Man对象反序列化成功");
        objectInputStream.close();
        return man;
    }
}
