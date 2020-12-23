package com.yh.junit.chartest;

import java.util.ArrayList;
import java.util.List;

/**
 * CharTest02 class
 *
 * @author yh
 * @date 2020/12/22
 */
public class CharTest02 {
    public static void main(String[] args) {
        char start = 'A';
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        getChar(list, start);
    }

    private static void getChar(List<Integer> list, char start) {
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            char sequence = (char) (start + integer - 10);
            System.out.println(sequence);
            System.out.println("-------------------");
            System.out.println(String.valueOf(sequence));
        }
    }
}
