package com.yh.junit.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * AssertTest class
 *
 * @author yh
 * @date 2020/12/23
 */
public class AssertTest {

    @Test
    public void test01() {
        List<String> list = null;
        assert list != null;

        List<String> list2 = new ArrayList<>();
        list2.add("11");
        System.out.println(list2);
    }
}
