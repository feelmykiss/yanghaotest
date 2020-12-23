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
}
