package com.yh.junit.list;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest02 {


    @Test
    public void test01() {
        List<String> list1 = Arrays.asList("a","b","c");
        List<String> list2 = Arrays.asList("c","d","e");
        Map<String, List<String>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);
        System.out.println(map);
        System.out.println(map.get("list3"));
    }

    @Test
    public void test02() {
        int num1 = 100;

        System.out.println(num1/30);
    }

    @Test
    public void test03() {
        List<String> list1 = Arrays.asList("a","b","c");
        list1.remove("a");
    }
}
