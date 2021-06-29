package com.intert;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IpTest class
 *
 * @author yh
 * @date 2021/1/14
 */
public class IpTest {
    public static void main(String[] args) throws UnknownHostException {

        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }
}
