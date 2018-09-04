package com.java.dubbo.demo.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.java.dubbo.demo.DemoService;
import com.java.dubbo.demo.DemoServiceImpl;

/**
 * @author xzmeasy
 * @since 18-9-4
 */
public class ApiProvider {

    public static void main(String[] args) {

        // 提供者引用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("helloworld-app");

        // 协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);

        // 注册中心配置
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");

        // 服务配置(重点, 最好缓存使用)
        ServiceConfig<DemoService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setRef(new DemoServiceImpl());

        // 暴露以及注册服务
        serviceConfig.export();

        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
