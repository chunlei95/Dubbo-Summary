package com.java.dubbo.demo.annotation;

import com.alibaba.dubbo.config.annotation.Reference;
import com.java.dubbo.demo.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xzmeasy
 * @since 18-9-4
 */
public class AnnotationConsumer {

    //@Reference
    //private DemoService demoService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        String world = demoService.sayHello("World");
        System.out.println(world);
    }

}
