package com.yh.junit.bigdecimal;

import com.yh.junit.domain.Student;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BgTest01 {

    @Test
    public void test01() {
        List<Student> studentList = new ArrayList<>();
        Student st1 = new Student();
        st1.setId(new BigDecimal(100));
        st1.setName("张三");
        Student st2 = new Student();
        st2.setId(new BigDecimal(110));
        st2.setName("李四");
        Student st3 = new Student();
        st3.setId(new BigDecimal(120));
        st3.setName("王五");
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        BigDecimal reduce = studentList.stream()
                .map(Student::getId)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);
    }


    @Test
    public void test02() {

        BigDecimal b1 = new BigDecimal("105425924000");
        BigDecimal b2 = new BigDecimal(795 * 1000 * 3600);
        BigDecimal divide = b1.divide(b2, 1, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
    }

    @Test
    public void test03() {

        BigDecimal b1 = new BigDecimal(112);
        BigDecimal b2 = new BigDecimal(200);
        BigDecimal divide = b1.divide(b2, 4, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
    }
}
