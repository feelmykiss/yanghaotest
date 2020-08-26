package com.yh.junit.jdk8;

import com.yh.junit.domain.Person;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListMapTest {

    @Test
    public void test01() {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("woId", "TESTWO001");
        map1.put("qty", "200");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("woId", "TESTWO002");
        map2.put("qty", "2001");
        Map<String, Object> map3 = new HashMap<>();
        map3.put("woId", "TESTWO001");
        map3.put("qty", "200");
        Map<String, Object> map4 = new HashMap<>();
        map4.put("woId", "TESTWO002");
        map4.put("qty", "2001");
        Map<String, Object> map5 = new HashMap<>();
        map5.put("woId", "TESTWO001");
        map5.put("qty", "200222");
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        mapList.add(map5);
        Map<Object, List<Map<String, Object>>> woId = mapList.stream()
                .collect(Collectors.groupingBy(map -> map.get("woId")));
        System.out.println(woId);
    }

    @Test
    public void test02() {
        Person person = new Person();
        person.setName("张三");
        person.setBook("1212");
        person.setHome("-----");
        Person person2 = new Person();
        person2.setName("李四");
        person2.setBook("121230");
        person2.setHome("-----");
        Person person3 = new Person();
        person3.setName("王五");
        person3.setBook("121231");
        person3.setHome("-----");
        Person person4 = new Person();
        person4.setName("赵六");
        person4.setBook("121232");
        person4.setHome("-----");
        Person person5 = new Person();
        person5.setName("赵六");
        person4.setHome("-----");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        /*Map<String, List<Person>> collect = personList.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (StringUtils.isNotBlank(p.getBook())) {
                        return p.getBook();
                    } else {
                        return "";
                    }
                }));*/
        Map<String, List<Person>> collect = personList.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (StringUtils.isNotBlank(p.getBook())) {
                        return p.getBook();
                    } else {
                        return "";
                    }
                }));
        System.out.println(collect.keySet());
    }

    @Test
    public void test03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 11);
        map.put("bbb", 22);
        map.put("ccc", 33);
        map.put("ddd", 44);
        map.put("eee", 55);

        System.out.println(map);

    }

    @Test
    public void test04() {
        Person person = null;
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        List<String> homeList = personList.stream().map(Person::getHome).distinct().collect(Collectors.toList());
        String join = StringUtils.join(homeList, ";");
        System.out.println(join);

    }
    @Test
    public void test05() {
        List<String> List = new ArrayList<>();
        String join = StringUtils.join(List, ";");
        System.out.println(join);

    }
}
