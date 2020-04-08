package com.yh.junit.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDataFormatTest01 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String format = sdf.format(new Date());
        System.out.println(format);
        // format = 190917
    }
}
