package com.yh.junit.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * SetTest class
 *
 * @author yh
 * @date 2021/1/7
 */
public class SetTest {
    @Test
    public void test01() {
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("aaa");
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.add("bbb");
        System.out.println(set);
    }
}
