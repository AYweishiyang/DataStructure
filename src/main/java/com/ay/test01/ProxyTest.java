package com.ay.test01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ay
 * @create 2020-07-26 16:12
 */
public class ProxyTest {
    JDKProxy jdkProxy = new JDKProxy();
}

class JDKProxy implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}