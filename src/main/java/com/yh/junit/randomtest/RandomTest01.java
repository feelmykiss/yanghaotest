package com.yh.junit.randomtest;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * RandomTest01 class
 *
 * @author yh
 * @date 2020/12/23
 */
public class RandomTest01 {

    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            long time = (new Date()).getTime();
            Random rand = new Random();
            BigDecimal bigDecimal = BigDecimal.valueOf(rand.nextInt(10000));
//            BigDecimal bigDecimal = BigDecimal.valueOf(time * 100 + rand.nextInt(100));
            System.out.println(bigDecimal);
        }

    }

    /**
     * 四位随机数字加字母
     * NA3L
     * CZHY
     * hIEz
     * tvvK
     * O1OJ
     */
    @Test
    public void test1() {
        for (int i = 0; i < 20; i++) {
            // 四位数字加字母
            String randomAlphabetic = RandomStringUtils.randomAlphanumeric(4);
            System.out.println(randomAlphabetic);

            System.out.println("-------------------------");
            // 四位字母
            String s = RandomStringUtils.randomAlphabetic(4);
            System.out.println(s);

        }

    }


    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            String random = RandomStringUtils.randomNumeric(4);
            System.out.println(random);

        }

    }

    @Test
    public void test3() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String date = df.format(new Date());
            Thread.sleep(1000);
            System.out.println(date);
        }

    }
}
