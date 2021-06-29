package com.mes.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * RandomTest01 class
 *
 * @author yh
 * @date 2021/1/22
 */
public class RandomTest01 {

    @Test
    public void  randomNumber() {
        long time = (new Date()).getTime();
        Random rand = new Random();
        BigDecimal bigDecimal = BigDecimal.valueOf(time * 100 + rand.nextInt(100));
        System.out.println(bigDecimal);
    }
}
