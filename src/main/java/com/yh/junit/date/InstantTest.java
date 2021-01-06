package com.yh.junit.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * InstantTest class
 *
 * @author yh
 * @date 2020/12/24
 */
public class InstantTest {

    /**
     * 同时解析毫秒微秒的 pattern
     */
    @Test
    public void test7() {
        String withMillis = "2019-02-14 11:04:52.784";
        String withMicros = "2019-02-14 11:04:52.784108";
        DateTimeFormatter DATE_TIME_FORMATTER =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.[SSSSSS][SSS]");
        System.out.println(LocalDateTime.parse(withMillis, DATE_TIME_FORMATTER));
        System.out.println(LocalDateTime.parse(withMicros, DATE_TIME_FORMATTER));
        String format = DATE_TIME_FORMATTER.format(LocalDateTime.now());
        System.out.println(format);
    }


    /**
     * java 9 之后可以拿到微秒 ?
     * linux 可以拿到微秒 ?
     *
     * @throws InterruptedException
     */
    @Test
    public void test8() throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            DateTimeFormatter DATE_TIME_FORMATTER =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            Thread.sleep(122);
            Instant now = Instant.now();
            System.out.println(now);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
            System.out.println(localDateTime);
            String format = DATE_TIME_FORMATTER.format(localDateTime);
            System.out.println(format);
        }
    }

    @Test
    public void test01() {
        Instant now = Instant.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault());
        System.out.println(dateTimeFormatter.format(now));

    }

    @Test
    public void test2() throws InterruptedException {
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        System.out.println(zdt);
    }

    @Test
    public void test3() throws InterruptedException {
        String format = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(Instant.now().atZone(ZoneId.systemDefault()).truncatedTo(ChronoUnit.MILLIS));
        String format2 = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(Instant.now().atZone(ZoneId.systemDefault()).truncatedTo(ChronoUnit.MICROS));
        String format3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(Instant.now().atZone(ZoneId.systemDefault()).truncatedTo(ChronoUnit.NANOS));
        System.out.println(format);
        System.out.println(format2);
        System.out.println(format3);
    }

    @Test
    public void test4() {
        String input = "2014-11-10 04：05：06.999999";
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
                .appendFraction(ChronoField.NANO_OF_SECOND, 0, 9, true)
                .toFormatter();
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(formatter);
        System.out.println(format);

    }

    @Test
    public void test5() {
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        System.out.println(instant.toString());

        String format = DateTimeFormatter.ISO_INSTANT.format(Instant.now().atZone(ZoneId.systemDefault()));
        System.out.println(zonedDateTime);
        System.out.println(format);

    }

    /**
     * DateTimeFormatter 默认格式化方式 example
     */
    @Test
    public void test6() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_DATE.format(ldt));
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(ldt));
    }

    @Test
    public void test9() {
        String withMicros = "2019-02-14 11:04:52.784108";
        DateTimeFormatter DATE_TIME_FORMATTER =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime parse = LocalDateTime.parse(withMicros, DATE_TIME_FORMATTER);
        System.out.println(parse);
        String format = DATE_TIME_FORMATTER.format(parse);
        System.out.println(format);
    }

    @Test
    public void test10() throws InterruptedException {

        for (int i = 0; i < 30; i++) {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
            DateTimeFormatter DATE_TIME_FORMATTER =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            String format = DATE_TIME_FORMATTER.format(now);
            System.out.println(format);
            Thread.sleep(233);
        }
    }

    @Test
    public void test11() {
        final Instant instant = Instant.now(Clock.systemDefaultZone());
        System.out.println(instant);
        System.out.println(instant.getNano());
    }


}
