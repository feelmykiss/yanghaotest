package com.yh.junit.math;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Test01 {

    @Test
    public void test01() {
        long i = 162;
        long i1 = i / 60;
        long i2 = i % 60;
        System.out.println(i1);
        System.out.println(i2);
    }
    @Test
    public void test02() {
        long i = 1600;
        long i1 = 1500;
        long i2 = i/i1;
        System.out.println(i2);
    }

    @Test
    public void test03() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1, 0);
        list.add(0, 123);
        System.out.println(list);
    }

    @Test
    public void test04() {
        Long l1 = 100L;
        Long l2 = 21L;
        double v = l2 * 1.0 / l1;
        Long l3 = 100L;
        Long l4 = 20L;
        double v2 = l4 * 1.0 / l3;
        System.out.println(v);
        System.out.println(v2);
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");

        if (Math.round(v2) - v2 == 0) {

        }

        String format = decimalFormat.format(v);
        String format2 = decimalFormat.format(v2);
        System.out.println(format);
        System.out.println(format2);
    }

    @Test
    public void test05() {

        double d1 = 0.1200;
        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        System.out.println(numberFormat.format(d1));
    }

    @Test
    public void test06() {
        BigDecimal b1 = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal("2");
        System.out.println(b1.compareTo(b2));

        BigDecimal b3 = new BigDecimal("9");
        BigDecimal b4= new BigDecimal("2");
        System.out.println(b3.compareTo(b4));
    }
}
