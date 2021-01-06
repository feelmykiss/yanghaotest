package com.yh.junit.date;

/**
 * NanoSecondTest class
 *
 * @author yh
 * @date 2020/12/24
 */

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NanoSecondTest2 {
    @Test
    public void test1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            String formatOut2 = "yyyy-MM-dd'T'HH:mm:ss.SSS[SSS]";
            LocalDateTime ldt2 = LocalDateTime.now();
            Thread.sleep(210);
            //必须要指定时区，要不然会报java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
            ZonedDateTime zdt2 = ZonedDateTime.of(ldt2, ZoneId.systemDefault());
            String out3 = DateTimeFormatter.ofPattern(formatOut2).format(zdt2);
            System.out.println("LocalDateTime out:" + out3);

            Instant instant = Instant.now().truncatedTo(ChronoUnit.MICROS);
            ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
            System.out.println(zonedDateTime.toString());
            System.out.println("--------------");
        }
    }

    @Test
    public void test11() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            String formatOut2 = "yyyy-MM-dd'T'HH:mm:ss.SSS[SSS]";
            LocalDateTime ldt2 = LocalDateTime.now();
            Thread.sleep(210);
            //必须要指定时区，要不然会报java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: OffsetSeconds
            ZonedDateTime zdt2 = ZonedDateTime.of(ldt2, ZoneId.systemDefault());
            String out3 = DateTimeFormatter.ofPattern(formatOut2).format(zdt2);
            System.out.println("LocalDateTime out:" + out3);
            System.out.println("--------------");
        }
    }

    @Test
    public void test2() throws InterruptedException {
        DateTimeFormatter DATE_TIME_FORMATTER =
                new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE)
                        .appendLiteral(' ')
                        .appendPattern("HH:mm:ss")
                        .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 9, true)
                        .toFormatter();
    }

    @Test
    public void test3() throws InterruptedException {
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        System.out.println(zdt);
    }
}
