package com.yh.junit.chartest;

import org.junit.Test;

/**
 * CharTest01 class
 *
 * @author yh
 * @date 2020/12/21
 */
public class CharTest01 {

    @Test
    public void test() {
        for (int i = 0; i < 50; i++) {
            if (i >= 9) {
                char start = 'A';
                char sequence = (char) (start + i - 9);
                System.out.println(sequence);
            }


        }
    }
}
