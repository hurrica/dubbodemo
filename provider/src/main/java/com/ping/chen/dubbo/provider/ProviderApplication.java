package com.ping.chen.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ping.chen on 2018/7/1.
 */
@SpringBootApplication
@DubboComponentScan("com.ping.chen.dubbo.provider.service.impl")
public class ProviderApplication {
    public static void main(String[] args) throws Exception {
        System.setProperty("spring.config.location", "classpath:provider.properties");
        SpringApplication.run(ProviderApplication.class, args);
        System.in.read();
    }
}
