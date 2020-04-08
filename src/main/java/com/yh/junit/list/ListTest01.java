package com.yh.junit.list;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest01 {


    @Test
    public void test01() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        System.out.println(list);
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("a","b","c","d");
        int a = list.indexOf("d");
        List<String> sublist= list.subList(a+1,4);

        System.out.println(sublist);
    }
}
