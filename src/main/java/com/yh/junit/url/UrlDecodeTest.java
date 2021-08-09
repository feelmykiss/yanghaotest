package com.yh.junit.url;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * UrlDecodeTest class
 *
 * @author YH
 * @date 2021/8/2
 */
public class UrlDecodeTest {

    @Test
    public void test01() throws UnsupportedEncodingException {
        String decode = URLDecoder.decode("%09", "UTF-8");
        System.out.println(decode);
    }
}
