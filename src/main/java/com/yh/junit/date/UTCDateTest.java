package com.yh.junit.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UTCDateTest {

    /**
     * UTC标准时间转 java 时间
     *
     * @throws ParseException
     */
    @Test
    public void UTCTest01() throws ParseException {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateString = "2020-06-03T05:51:46.130Z";
        Date date = simpleDateFormat.parse(dateString);
        System.out.println(date);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat1.format(date));
    }

}
