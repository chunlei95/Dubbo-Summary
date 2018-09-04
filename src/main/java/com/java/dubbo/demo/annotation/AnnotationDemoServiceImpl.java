package com.java.dubbo.demo.annotation;

import com.alibaba.dubbo.config.annotation.Service;
import com.java.dubbo.demo.DemoService;

/**
 * 使用@Service注解暴露服务
 *
 * @author xzmeasy
 * @since 18-9-4
 */
@Service(timeout = 1000)
public class AnnotationDemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
