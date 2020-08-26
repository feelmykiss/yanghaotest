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
}
