package com.java.dubbo.demo.annotation;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xzmeasy
 * @since 18-9-4
 */
@EnableDubbo
@Configuration
@Import({AnnotationConsumerConfig.class, AnnotationProviderConfig.class})
public class SpringConfig {


}
