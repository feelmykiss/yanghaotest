package com.yh.junit.list;


import com.sun.deploy.util.StringUtils;
import com.yh.junit.domain.Student;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 文档注释
 * 文档文档注释 注释 注释
 */
public class ListTest02 {


    @Test
    public void test01() {
        // 单行注释 单行注释
        // 单行注释 单行注释
        // 单行注释 单行注释
        // 单行注释 单行注释
        // 单行注释 单行注释
        /* 多行注释多行注释 多行注释
            多行注释多行注释 多行注释
            多行注释多行注释 多行注释
            多行注释多行注释 多行注释
            多行注释多行注释 多行注释
         多行 多行注释 注释注释 注释 */
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("c", "d", "e");
        Map<String, List<String>> map = new HashMap<>();
        map.put("list1", list1);
        map.put("list2", list2);
        System.out.println(map);
        System.out.println(map.get("list3"));
    }

    @Test
    public void test02() {
        int num1 = 100;

        System.out.println(num1 / 30);
    }

    @Test
    public void test03() {
        List<String> list1 = Arrays.asList("a", "b", "c");
        list1.remove("a");
    }

    @Test
    public void test04() {
        List<String> list1 = new ArrayList<>();

        String join = StringUtils.join(list1, ";");
        System.out.println(join);
        System.out.println(org.apache.commons.lang3.StringUtils.isNotBlank(join));
    }

    @Test
    public void test05() {
        List<String> list1 = Arrays.asList("a", "b", "c", "", "d");
        System.out.println(StringUtils.join(list1, ";"));
    }

    @Test
    public void test06() {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "aaaa");
        map.put("bbb", "bbb");
        map.put("ccc", "ccc");
        map.put("ddd", "ddd");
        map.put("eee", "eee");
        Collection<String> values = map.values();
        List<String> list = new ArrayList<>(values);
        System.out.println(list);
    }

    @Test
    public void test07() {
        BigDecimal bigDecimal1 = new BigDecimal(0);
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        int i = bigDecimal1.compareTo(bigDecimal2);
        System.out.println(i);
    }

    @Test
    public void test08() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("aa");
        list2.add("bb");
        list2.add("cc");
        list2.add("dd");
        System.out.println(list2.isEmpty() || list2.contains("aa"));
    }

    @Test
    public void test09() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        List<String> list2 = new ArrayList<>();
        list2.add("d");
        list2.add("e");
        list2.add("f");
        list2.add("g");
        list1.retainAll(list2);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("list2最后一个元素" + list2.get(list2.size() - 1));
    }

    @Test
    public void test10() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2020-06-18");
        Date date2 = sdf.parse("2020-06-22");
        Date date3 = sdf.parse("2020-02-11");
        Date date4 = sdf.parse("2020-02-22");
        Student student1 = new Student();
        student1.setName("tom");
        student1.setDate(date1);
        Student student2 = new Student();
        student2.setName("张四");
        student2.setDate(date2);
        Student student3 = new Student();
        student3.setName("张五");
        student3.setDate(date3);
        Student student4 = new Student();
        student4.setName("Jerry");
        student4.setDate(date4);
        List<Student> list1 = Arrays.asList(student2, student1, student3, student4);
        list1.forEach(student -> {
            System.out.println(student.getName());
            System.out.println(sdf.format(student.getDate()));
        });
        System.out.println("-------------------");
        list1.sort(Comparator.comparing(Student::getDate));
        list1.forEach(student -> {
            System.out.println(student.getName());
            System.out.println(sdf.format(student.getDate()));
        });
        System.out.println("names");
        String names = list1.stream().map(Student::getName).collect(Collectors.joining(";"));
        System.out.println(names);
    }

    @Test
    public void test11() {
        BigDecimal bigDecimal1 = new BigDecimal("0.0000");
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        System.out.println(bigDecimal1.compareTo(bigDecimal3));
    }

    @Test
    public void test12() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2020-06-18");
        Date date2 = sdf.parse("2020-06-22");
        Date date3 = sdf.parse("2020-02-11");
        Date date4 = sdf.parse("2020-02-22");
        Student student1 = new Student();
        student1.setName("张三");
        student1.setDate(date1);
        Student student2 = new Student();
        student2.setName("张五");
        student2.setDate(date2);
        Student student3 = new Student();
        student3.setName("张五");
        student3.setDate(date3);
        Student student4 = new Student();
        student4.setName("");
        student4.setDate(date4);
        List<Student> list1 = Arrays.asList(student2, student1, student3, student4);
        Map<String, List<Student>> collect = list1.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(collect);
    }

    @Test
    public void tet13() {
        String str = "镀膜二";
        String substring = str.substring(str.length() - 1);
        System.out.println(substring);
        String s = str + "2";
        System.out.println(s);
    }

    @Test
    public void test14() {
        String str = "12";
        String[] split = str.split("-");
        System.out.println(Arrays.asList(split));
    }

    @Test
    public void test15() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        List<String> strings = list.subList(0, list.size());
        System.out.println(strings);
    }

    @Test
    public void test16() {
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        map.put("ccc", 333);
        map.put("ddd", 444);
        map.forEach((key, value) ->
        {
            System.out.println(key);
            System.out.println(value);
        });
    }

    @Test
    public void test17() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        map.put("ccc", 333);
        map.put("ddd", 444);
        for (Map.Entry<String, Integer> entry1 : map.entrySet()) {
            System.out.println(entry1.getKey());
            System.out.println(entry1.getValue());
        }
    }

}
