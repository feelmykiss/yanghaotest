package com.yh.junit.list;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest01 {


    @Test
    public void test01() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        System.out.println(list);
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("a","b","c","d");
        int a = list.indexOf("d");
        List<String> sublist= list.subList(a+1,4);

        System.out.println(sublist);
    }
    @Test
    public void test03() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<24;i++){
            list.add(i);
        }
        for(int i= 0;i < list.size() / 2;i++){
            List<Integer> insertList = list.subList(i*2, (i+1)*2);
            System.out.println(insertList);
        }
        if(list.size() % 3 != 0){
            System.out.println("最后剩余的数据："+list.subList((list.size() / 3) * 2, list.size()));
        }else{
            System.out.println("正好整批处理成功");
        }
    }
}
