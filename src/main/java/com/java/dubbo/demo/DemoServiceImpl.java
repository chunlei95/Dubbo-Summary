package com.java.dubbo.demo;

/**
 * @author xzmeasy
 * @since 18-9-4
 */
public class DemoServiceImpl implements DemoService{

    @Override
    public String sayHello(String name) {
        return "Hello" + name;
    }
}
