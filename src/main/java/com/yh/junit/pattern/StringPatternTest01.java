package com.yh.junit.pattern;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringPatternTest01 class
 *
 * @author yh
 * @date 2020/12/29
 */
public class StringPatternTest01 {

    /**
     * 正则匹配字符串
     */
    @Test
    public void test01() {
        String details = "PrintClient#generateRunCard(PrintRunCardVM) failed and no fallback available.";
        Pattern pattern = Pattern.compile("PrintClient#(.*?)failed and no fallback available");
        Matcher matcher = pattern.matcher(details);
        System.out.println(matcher.find());
    }


    /**
     * 日期 正则匹配字符串
     */
    @Test
    public void test02() throws ParseException {
        String str1 = "21/02/06 00:42:06";
        String str2 = "21/02/06 03:21:46: CarryIn/Out End";
        // yy/MM/dd HH:mm:ss
        Pattern pattern = Pattern.compile("\\d{2}/\\d{2}/\\d{2}\\s\\d{2}:\\d{2}:\\d{2}");
        Matcher matcher = pattern.matcher(str1);
        Matcher matcher2 = pattern.matcher(str2);
        System.out.println(matcher2.find());
        String group = matcher2.group();
        System.out.println(group);
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
        Date parse1 = sdf.parse(group);
        System.out.println(parse1);
    }
}
