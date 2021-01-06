package com.yh.junit.pattern;

import org.junit.Test;

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
}
