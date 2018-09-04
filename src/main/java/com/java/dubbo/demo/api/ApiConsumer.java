package com.java.dubbo.demo.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.java.dubbo.demo.DemoService;

/**
 * @author xzmeasy
 * @since 18-9-4
 */
public class ApiConsumer {

    public static void main(String[] args) {

        // 消费方应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumer-of-helloworld-app");

        // 链接注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");

        // 引用远程服务配置
        ReferenceConfig<DemoService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(DemoService.class);

        // 调用远程服务
        DemoService demoService = referenceConfig.get();
        String world = demoService.sayHello("world");
        System.out.println(world);

    }

}
