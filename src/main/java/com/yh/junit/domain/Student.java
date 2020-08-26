package com.yh.junit.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Student {
    private BigDecimal id;
    private String name;
    private Date date;
}
