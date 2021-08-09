package com.yh.junit.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Man class
 *
 * @author YH
 * @date 2021/6/29
 */
@Data
@ToString(callSuper = true)
public class Man extends Person {
    private String car;
    private String watch;
    private String other;
}
