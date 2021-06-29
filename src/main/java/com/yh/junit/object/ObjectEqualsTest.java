package com.yh.junit.object;

import com.yh.junit.domain.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ObjectEqualsTest class
 *
 * @author yh
 * @date 2021/1/13
 */
public class ObjectEqualsTest {


    @Test
    public void test01() {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        System.out.println(Objects.equals(person1.getBook(), person1.getBook()));
        System.out.println(Objects.equals(person1.getBook(), person1.getBook()));
        System.out.println(Objects.equals(person3, person2));
    }

    @Test
    public void test02() {
        Person person1 = new Person();
        person1.setBook("aaa");
        Person person2 = new Person();
        person2.setBook("bbb");
        Person person3 = new Person();
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getBook));
    }
}
