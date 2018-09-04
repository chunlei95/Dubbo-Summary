package com.java.dubbo.demo.annotation;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.java.dubbo.demo.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务提供方配置
 *
 * @author xzmeasy
 * @since 18-9-4
 */
@SuppressWarnings("JavaDoc")
@Configuration
public class AnnotationProviderConfig {

    /**
     * 服务提供者应用配置
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("HelloWorld-app");
        return applicationConfig;
    }

    /**
     * 注册中心配置
     *
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://localhost:2181");
        return registryConfig;
    }

    /**
     * 协议配置
     *
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /**
     * 服务配置
     *
     * @return
     */
    @Bean
    public ServiceConfig<AnnotationProviderConfig> serviceConfig() {
        ServiceConfig<AnnotationProviderConfig> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(DemoService.class);
        serviceConfig.setRef(new AnnotationProviderConfig());
        serviceConfig.setApplication(applicationConfig());
        serviceConfig.setRegistry(registryConfig());
        serviceConfig.setProtocol(protocolConfig());
        return serviceConfig;
    }

}
