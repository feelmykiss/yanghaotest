package com.yh.junit.file;

import org.junit.Test;

import java.io.File;

/**
 * PathTest class
 *
 * @author yh
 * @date 2021/3/4
 */
public class PathTest {

    @Test
    public void test01() {
        File file = new File(this.getClass().getResource("/").getPath());
        System.out.println(file.getAbsolutePath());
    }
}
