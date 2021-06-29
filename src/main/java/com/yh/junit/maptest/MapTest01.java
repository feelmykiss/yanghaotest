package com.yh.junit.maptest;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * MapTest01 class
 *
 * @author yh
 * @date 2020/12/23
 */
public class MapTest01 {

    /**
     * ImmutableMap中key和value均不能为null，放入null值会抛出NPE
     */
    @Test
    public void test() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("source1", "value1");
        dataMap.put("source2", null);
        ImmutableMap.copyOf(dataMap);
    }


    /**
     * Map puttAll 有重复的 key 效果:
     */
    @Test
    public void test1() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("source1", "value1");
        dataMap.put("source2", "1111");
        dataMap.put("source3", "1111");
        dataMap.put("source4", "1111");
        dataMap.put("source5", "1111");
        Map<String, Object> dataMap1 = new HashMap<>();
        dataMap1.put("source1", "1");
        dataMap1.put("source2", "2");
        dataMap1.put("source3", "3");
        dataMap.putAll(dataMap1);
        dataMap.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });

    }
}
