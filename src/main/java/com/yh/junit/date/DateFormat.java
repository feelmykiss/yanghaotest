package com.yh.junit.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DateFormat class
 *
 * @author yh
 * @date 2021/6/23
 */
public class DateFormat {
    public static void main(String[] args) {
        String yearWeekCode = getYearWeekCode("20210623");
        System.out.println(yearWeekCode);

    }

    public static String getYearWeekCode(String yyyyMMdd) {
        String rStr = "";

        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            cal.setTime(format.parse(yyyyMMdd));
            int iweek = cal.get(3);
            int day = cal.get(5);
            int year = cal.get(1);
            int month = cal.get(2);
            cal.setTime(format.parse(String.valueOf(year) + "0101"));
            if (month == 11 && iweek == 1) {
                iweek = Integer.valueOf(getYearWeekCode(String.valueOf(year) + "12" + (day - 7)).substring(0, 2)) + 1;
            }

            String sWeek = String.valueOf(iweek);
            String sYear = String.valueOf(year);
            if (sWeek.length() == 1) {
                sWeek = "0" + sWeek;
            }

            rStr = sWeek + "-" + sYear;
        } catch (ParseException var11) {
            var11.printStackTrace();
        }

        return rStr;
    }
}
