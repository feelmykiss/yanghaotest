package com.yh.junit.list;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class ListTest01 {


    @Test
    public void test01() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        System.out.println(list);
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        int a = list.indexOf("d");
        List<String> sublist = list.subList(a + 1, 4);

        System.out.println(sublist);
    }

    @Test
    public void test03() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size() / 2; i++) {
            List<Integer> insertList = list.subList(i * 2, (i + 1) * 2);
            System.out.println(insertList);
        }
        if (list.size() % 3 != 0) {
            System.out.println("最后剩余的数据：" + list.subList((list.size() / 3) * 2, list.size()));
        } else {
            System.out.println("正好整批处理成功");
        }
    }

    @Test
    public void test04() {
        StringBuffer xmlSb = new StringBuffer();
        String blank = " ";
        xmlSb.append("<")
                .append("lll")
                .append(">")
                .append(blank)
                .append("</")
                .append("lll")
                .append(">");
        System.out.println(xmlSb);
    }


    @Test
    public void test05() {
        Map<String, String> map = new HashMap<>();
        map.put("ex1", "222");
        map.put("ex1", "222");
        map.put("ex1", "222");
        map.put("ex1", "333");
        System.out.println(map);
    }

    @Test
    public void test06() {
        Long l1 = 1599722690000L;
        Date date = new Date(l1);
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String format = sdf.format(date);
        System.out.println(format);
    }

    /**
     * 差集
     */
    @Test
    public void test07() {
        List<String> lsit1 = new ArrayList<>();
        lsit1.add("a");
        lsit1.add("b");
        lsit1.add("c");
        lsit1.add("d");
        lsit1.add("e");
        lsit1.add("f");

        List<String> lsit2 = new ArrayList<>();
        lsit2.add("a");
        lsit2.add("b");
        lsit2.add("c");
        lsit2.add("d");
        System.out.println(lsit1.removeAll(lsit2));
        System.out.println(lsit1);
        /**
         * true
         * [e, f]
         */
    }

    /**
     * 并集
     */
    @Test
    public void test08() {
        List<String> lsit1 = new ArrayList<>();
        lsit1.add("a");
        lsit1.add("b");
        lsit1.add("c");
        lsit1.add("d");
        lsit1.add("e");
        lsit1.add("f");

        List<String> lsit2 = new ArrayList<>();
        lsit2.add("a");
        lsit2.add("b");
        lsit2.add("c");
        lsit2.add("d");
        System.out.println(lsit1.retainAll(lsit2));
        System.out.println(lsit1);
        /**
         * true
         * [e, f]
         */
    }

}
