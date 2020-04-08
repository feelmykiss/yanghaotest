package com.yh.junit.jdk8;

import com.yh.junit.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setAddress("北京");
        person1.setName("张三");
        person1.setAge(18);
        person1.setNational("中国");
        person1.setSex("男");

        Person person2 = new Person();
        person2.setAddress("北京");
        person2.setName("张三");
        person2.setAge(18);
        person2.setNational("中国");
        person2.setSex("男");

        Person person3 = new Person();
        person3.setAddress("北京");
        person3.setName("李四");
        person3.setAge(18);
        person3.setNational("中国");
        person3.setSex("男");

        Person person4 = new Person();
        person4.setAddress("北京");
        person4.setName("张三");
        person4.setAge(19);
        person4.setNational("中国");
        person4.setSex("男");

        Person person5 = new Person();
        person5.setAddress("北京");
        person5.setName("李四");
        person5.setAge(18);
        person5.setNational("中国");
        person5.setSex("男");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        List<String> collect = person1.getPieceList().stream().map(Person.Piece::getPieceId).collect(Collectors.toList());
        System.out.println(collect);

    }
}
