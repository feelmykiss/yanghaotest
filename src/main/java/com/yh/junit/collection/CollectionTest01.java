package com.yh.junit.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * CollectionTest01 class
 *
 * @author yh
 * @date 2021/5/24
 */
public class CollectionTest01 {

    @Test
    public void test01() {

        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("m", "g", "h"));
        boolean disjoint = Collections.disjoint(list1, list2);
        System.out.println(disjoint);
    }
}
