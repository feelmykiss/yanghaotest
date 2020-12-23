package com.yh.junit.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringTest02 {

    @Test
    public void resolveColumnByPosition() {
        String mtrlBarCode = "ABB90";
        String extendColumnPosition = "22^2";
        String result = null;
        if (StringUtils.isNotBlank(extendColumnPosition)) {

            String[] split = extendColumnPosition.split("\\^");
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
                System.out.println(i);
            }

            Integer start = Integer.valueOf(split[0]) - 1;

            Integer end = Integer.valueOf(split[1]);
            System.out.println(start);
            System.out.println(end);
            // 当barCode长度 大于 结束位置时  截取
            if (mtrlBarCode.length() >= end) {
                result = mtrlBarCode.substring(start, end);
            }
        }
        System.out.println(result);
    }
}
