package com.yh.junit.string;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class StringTest01 {

    @Test
    public void test01() {
        String st1 = "111";
        String st2 = "";
        System.out.println(Objects.equals(st1, st2));
    }


    @Test
    public void test02() {
        String st1 = null;

        List<String> strings = Arrays.asList(st1.split("[" + ";" + ";" + "]"));
        System.out.println(strings);
    }

    @Test
    public void test03() {
        String st1 = "'崩点/崩边/内崩";
        String s = st1.replaceAll("/", "");
        System.out.println(s);
    }

    @Test
    public void test04() {
        String st1 = "['','']";
        List<String> strList = JSONObject.parseArray(st1, String.class);
        List<Date> dateList = new ArrayList<>();
        for (String s : strList) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date parse = formatter.parse(s);
                System.out.println(parse);
                dateList.add(parse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(strList.size());
        System.out.println(strList);
        System.out.println(dateList);
    }

    @Test
    public void test05() {
        Object object = "['','']";
        String[] array = (String[])object;
        System.out.println(array);
    }



}
