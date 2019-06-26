package com.xmcc.test;

import com.xmcc.entity.Users;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @company xmcc
 * @create create by qcc on 2019-06-25 14:42
 */
public class ProxyTest {


    @Test
    public void test(){
        Gongneng as = (Gongneng) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Gongneng.class}, (a, b, c) -> {
            System.out.println("asdsadas");
            return null;
        });

        as.performance();
    }
}
