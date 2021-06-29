package com.yh.junit.random;

import org.junit.Test;

import java.util.Calendar;

/**
 * RandomTest02 class
 *
 * @author YH
 * @date 2021/6/25
 */
public class RandomTest02 {

    @Test
    public void test01() {
        for (int i = 0; i < 10; i++) {
            long nanoMillisecond = System.nanoTime();
            Calendar calendar = Calendar.getInstance();
            // mrNo 的最后 11位 + 时 + 分 + 秒 + 毫秒
            String tcWmsId = "流水码测试:" + calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE) +
                    calendar.get(Calendar.SECOND) + nanoMillisecond;
            System.out.println("毫秒" + calendar.get(Calendar.MILLISECOND));
            System.out.println("纳秒换算微秒" + nanoMillisecond / 1000);
            System.out.println("纳秒" + nanoMillisecond);

            System.out.println(tcWmsId);
        }
    }

    @Test
    public void test02() {
        for (int i = 0; i < 10; i++) {
            Calendar calendar = Calendar.getInstance();
            // mrNo 的最后 11位 + 时 + 分 + 秒 + 毫秒
            // modify at [2021/6/25] by YH: 毫秒会导致 tcWmsId 重复.  tcWmsId 最后一部分由毫秒改为 微秒
            // 当前系统 纳秒/1000
            long nanoMillisecond = System.nanoTime();
            long microsecond = nanoMillisecond / 1000;
            String tcWmsId = "mrNoEnd" + calendar.get(Calendar.HOUR_OF_DAY) + calendar.get(Calendar.MINUTE) +
                    calendar.get(Calendar.SECOND) + microsecond;
            System.out.println("毫秒" + calendar.get(Calendar.MILLISECOND));
            System.out.println("纳秒" + nanoMillisecond);
            System.out.println("纳秒换算微秒" + microsecond);

            System.out.println(tcWmsId);
        }
    }
}
