package com.ping.chen.dubbo.comsumer;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ping.chen on 2018/7/1.
 */
@SpringBootApplication
@DubboComponentScan("com.ping.chen.dubbo.comsumer")
public class ConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
