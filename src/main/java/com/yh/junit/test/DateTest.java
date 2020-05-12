package com.yh.junit.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    @Test
    public void test01() {
        Date date1 = new Date(1585876489967L);
        Date date2 = new Date(1578743735000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date1);
        String format2 = simpleDateFormat.format(date2);
        System.out.println("date1->" + format1);
        System.out.println("date2->" + format2);
    }

    @Test
    public void test02() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(date + "-->观察文件变化任务开始");
    }

    @Test
    public void test03() {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date1);
        System.out.println("当前时间->" + format1);
        System.out.println("当前时间 long 类型->" + date1.getTime());
    }

    @Test
    public void test04() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2018, 3, 17, 17, 15, 22);
        long milli = calendar.getTimeInMillis();
        Date date = new Date(milli);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("java原生时间: " + simpleDateFormat.format(date));
        System.out.println("java原生ticks: " + milli);
        long ticks = ((milli+28800000) * 10000) + 621355968000000000L;
        System.out.println("C# tickets: " + ticks);

        // 通过 java 转的 636595533220000000
        // C# 自己得到的   636595821220000000

    }

    @Test
    public void test05() {
        long l1 = (637248728780830000L - 621355968000000000L) / 10000-28800000;
        Date date1 = new Date(l1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = sdf.format(date1);
        System.out.println("epms run time");
        System.out.println(format1);

        long l2 = (637248036260000000L - 621355968000000000L) / 10000-28800000;
        Date date2 = new Date(l2);
        String format2 = sdf.format(date2);
        System.out.println("epms idle time");
        System.out.println(format2);
    }

    @Test
    public void test06() {
        long milli = System.currentTimeMillis();
        Date date = new Date(milli);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("java原生时间: " + simpleDateFormat.format(date));
        System.out.println("java原生ticks: " + milli);
        long ticks = ((milli + 28800000) * 10000) + 621355968000000000L;
        System.out.println("C# tickets: " + ticks);

        // 通过 java 转的 637234649956310000
        // C# 自己得到的   637234721845355750

    }


}
