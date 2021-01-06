package com.yh.junit.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateCompareTest01 class
 *
 * @author yh
 * @date 2021/1/6
 */
public class DateCompareTest01 {

    /**
     * 日期比较
     * @throws ParseException
     */
    @Test
    public void test01() throws ParseException {
        String str1 = "2020-01-04 00:00:00";
        String str2 = "2020-01-04 00:00:00";
        String str3 = "2020-01-04 00:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str2);
        Date date3 = sdf.parse(str3);
        System.out.println(!date2.before(date1));
        System.out.println(!date2.after(date3));
    }
}
