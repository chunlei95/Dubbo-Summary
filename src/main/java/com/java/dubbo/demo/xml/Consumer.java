package com.java.dubbo.demo.xml;

import com.java.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xzmeasy
 * @since 18-9-4
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        // 获取远程
        DemoService demoService = (DemoService) context.getBean("demoService");
        // 执行远程方法
        String world = demoService.sayHello("world");
        // 显示调用结果
        System.out.println(world);
    }

}
