package com.yh.junit.string;

import org.junit.Test;

/**
 * SubStringTest01 class
 *
 * @author YH
 * @date 2021/8/3
 */
public class SubStringTest01 {

    @Test
    public void test() {
        String str1 = "C_2107071307_0005";
        String substring = str1.substring(2, 8);
        System.out.println(substring);
    }
}
