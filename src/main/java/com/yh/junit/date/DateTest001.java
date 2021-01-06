package com.yh.junit.date;

import com.yh.junit.domain.Student;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest001 {

    @Test
    public void test01() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String yearStr = String.valueOf(year);
        yearStr = yearStr.substring(yearStr.length() - 2, yearStr.length());
        System.out.println(yearStr);
        System.out.println(day);
        System.out.println(month);

    }

    @Test
    public void test02() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2020-06-18");
        Date date2 = sdf.parse("2020-06-22");
        Date date3 = sdf.parse("2020-02-11");
        Date date4 = sdf.parse("2020-02-22");
        Student student1 = new Student();
        student1.setName("张三");
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
        Student student = list1.stream().min(Comparator.comparing(Student::getDate, Comparator.nullsLast(Date::compareTo))).get();
        String format = sdf.format(student.getDate());
        System.out.println(format);
    }

    @Test
    public void test3() throws InterruptedException {
        for (int i = 0; i < 300; i++) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            Calendar instance = Calendar.getInstance();
            Date time = instance.getTime();
            Thread.sleep(100L);
            String format = df.format(time);
            System.out.println(format);
        }
    }


}
