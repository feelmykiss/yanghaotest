package com.yh.junit.string;

import com.yh.junit.domain.Man;
import org.junit.Test;

/**
 * ToStringTest1 class
 *
 * @author YH
 * @date 2021/6/29
 */
public class ToStringTest1 {


    @Test
    public void test01() {
        Man man = new Man();
        man.setHome("home");
        man.setBook("book");
        man.setMoney("money");
        man.setCar("bus");
        man.setOther("other");
        man.setWatch("watch");

        System.out.println(man);
    }
}
