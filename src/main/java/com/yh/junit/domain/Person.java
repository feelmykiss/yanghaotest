package com.yh.junit.domain;

import lombok.Data;

@Data
public class Person {
    private String book;

    {
        String abc = "abc";
        book = abc;
    }

    private String name = "abc";
    private String sex = "abc";
    private String home = "abc";
    private String money = "abc";
    private String login = "abc";
    private String password = "abc";

}
