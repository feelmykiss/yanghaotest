package com.yh.junit.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    @Test
    public void test01() {
        Date date1 = new Date(1585876489967L);
        Date date2 = new Date(1578743735000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date1);
        String format2 = simpleDateFormat.format(date2);
        System.out.println("date1->"+format1);
        System.out.println("date2->"+format2);
    }

    @Test
    public void test02() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(date + "-->观察文件变化任务开始");
    }
}
