package com.yh.junit.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CollectionsTest01 class
 *
 * @author YH
 * @date 2021/8/4
 */
public class CollectionsTest01 {

    @Test
    public void test01(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1 = Collections.singletonList("aaa");
        list2 = Collections.singletonList("bbb");
        System.out.println(list1);
        System.out.println(list2);
    }
}
