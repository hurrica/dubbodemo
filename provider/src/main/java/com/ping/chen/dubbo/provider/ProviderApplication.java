package com.ping.chen.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Created by ping.chen on 2018/7/1.
 */
@SpringBootApplication
@DubboComponentScan("com.ping.chen.META-INF.provider")
public class ProviderApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
