package com.yuan.spring6.aop;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void testDynamicProxy(){
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.div(3,2);
        //proxy.div(1,1);
    }

}
