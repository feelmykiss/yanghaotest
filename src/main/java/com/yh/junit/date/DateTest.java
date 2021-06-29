package com.yh.junit.date;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

public class DateTest {

    /**
     * 将 1 2 3 4 5 6 7 8 小时数格式化为 1:00 2:00 。。。
     * 如果要将 1 2 3 4 5 6 7 8 小时数格式化为 01:00 02:00 。。。 这 HH:mm 即可
     */
    @Test
    public void test01() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 1);
        c.set(Calendar.MINUTE, 00);
        Date time = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
        String format = sdf.format(time);
        System.out.println(format);
    }

    @Test
    public void test02() {
        //java代码
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2018,3,17,17,15,22);
        long milli = calendar.getTimeInMillis();
        System.out.println("java原生ticks: " + milli);
    }

    @Test
    public void test03() {
        long time = System.currentTimeMillis();
        String format = ISO_LOCAL_DATE_TIME.format(Instant.ofEpochMilli(time).atZone(ZoneOffset.UTC));
        // "2017-03-07T12:09:04.374"
        System.out.println(format);

    }


    @Test
    public void test04() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm.ss.SSSSSS");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        System.out.println(nowAsISO);

    }

    @Test
    public void test05() {
        Date date=new Date(1620617229376L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        System.out.println("----------------------------");
        System.out.println(sdf.format(date));

    }
}
