package com.jwong.junit.test;

import org.junit.Test;

public class Ternaryoperation20190730 {

    public static void main(String[] args) {
        String lll = args[0];
        String str1 = lll;
        System.out.println(lll == str1);
        str1 = str1 == null ? "" : str1;
        System.out.println(str1);
    }
}
