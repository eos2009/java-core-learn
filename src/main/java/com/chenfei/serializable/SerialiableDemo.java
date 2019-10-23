package com.chenfei.serializable;

import com.chenfei.serializable.bean.Man;
import com.chenfei.serializable.bean.Person;
import com.chenfei.serializable.util.SerialiableUtil;

/**
 * @author chenfei
 * @description java序列化、反序列化
 * @since 2019/10/23
 */
public class SerialiableDemo {

    public static void main(String[] args) throws Exception{
        //SerialiableUtil.serialiablePerson();
        //Person person = SerialiableUtil.deserialiablePerson();
        //System.out.println(person.toString());


        //SerialiableUtil.serialiableMan();
        Man man = SerialiableUtil.deserialiableMan();
        System.out.println(man.toString());

    }
}
