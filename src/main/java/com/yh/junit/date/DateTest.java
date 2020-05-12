package com.yh.junit.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
}
