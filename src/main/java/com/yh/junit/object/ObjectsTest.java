package com.yh.junit.object;

import org.junit.Test;

import java.util.Objects;

/**
 * ObjectsTest class
 *
 * @author YH
 * @date 2021/6/29
 */
public class ObjectsTest {


    @Test
    public void test01() {
        String a = "123";
        String b = "";
        boolean equals = Objects.equals(a, b);
        System.out.println(equals);
    }
}
