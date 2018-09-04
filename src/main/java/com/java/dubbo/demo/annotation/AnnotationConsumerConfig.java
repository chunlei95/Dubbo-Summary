package com.java.dubbo.demo.annotation;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.java.dubbo.demo.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务调用方配置
 *
 * @author xzmeasy
 * @since 18-9-4
 */
@SuppressWarnings("JavaDoc")
@Configuration
public class AnnotationConsumerConfig {

    /**
     * 服务消费方应用配置
     *
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("consumer-of-helloWorld-app");
        return applicationConfig;
    }

    /**
     * 链接注册中心配置
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
     * 引用远程服务配置
     *
     * @return
     */
    @Bean
    public ReferenceConfig<AnnotationConsumerConfig> referenceConfig() {
        ReferenceConfig<AnnotationConsumerConfig> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(DemoService.class);
        referenceConfig.setApplication(applicationConfig());
        referenceConfig.setRegistry(registryConfig());
        return referenceConfig;
    }

}
