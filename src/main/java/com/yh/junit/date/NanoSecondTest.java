package com.yh.junit.date;

/**
 * NanoSecondTest class
 *
 * @author yh
 * @date 2020/12/24
 */

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class NanoSecondTest {
    public static void main(String[] args) throws Exception {
        String valueIn = "2019-02-19T23:28:04.434410+0800";
        String formatIn = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ";
        String formatOut = "yyyy-MM-dd HH:mm:ss";
        String formatOut2 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ";

        //使用SimpleDateFormat解析
        Date date = new SimpleDateFormat(formatIn).parse(valueIn);
        String out1 = new SimpleDateFormat(formatOut).format(date);
        System.out.println("SimpleDateFormat out:" + out1 + ",会多几分钟");

        //使用LocalDateTime
        //先获取时间纳秒
        LocalDateTime ldt = LocalDateTime.parse(valueIn, DateTimeFormatter.ofPattern(formatIn));
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
        String out2 = DateTimeFormatter.ofPattern(formatOut).format(zdt);
        System.out.println("LocalDateTime out:" + out2);

        //double类型时间2019-02-19T23:28:04.434410+0800=1550590084.434410还原yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ
        double d_time = 1550590084.434410;
        BigDecimal bd = new BigDecimal(d_time).setScale(6, BigDecimal.ROUND_DOWN);
        long Millitime = (long) (d_time * 1000);
        int Nano = Integer.parseInt(bd.toString().substring(bd.toString().indexOf(".") + 1) + "000");

        Date date1 = new Date(Millitime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH) + 1;
        int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        int HOUR_OF_DAY = calendar.get(Calendar.HOUR_OF_DAY);
        int MINUTE = calendar.get(Calendar.MINUTE);
        int SECOND = calendar.get(Calendar.SECOND);

        LocalDateTime ldt2 = LocalDateTime.of(YEAR, MONTH, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE, SECOND, Nano);
        //必须要指定时区，要不然会报java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
        ZonedDateTime zdt2 = ZonedDateTime.of(ldt2, ZoneId.systemDefault());
        String out3 = DateTimeFormatter.ofPattern(formatOut2).format(zdt2);
        System.out.println("LocalDateTime 1550590084.434410 out:" + out3);
    }
}
