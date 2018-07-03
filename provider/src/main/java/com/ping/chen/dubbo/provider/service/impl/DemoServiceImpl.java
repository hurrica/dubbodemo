package com.ping.chen.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ping.chen.dubbo.service.DemoService;

/**
 * Created by ping.chen on 2018/7/1.
 * 应该加上版本号，为后续不兼容升级提供可能
 * actives 每个消费者最大并发调用数
 *
 */
@Service(timeout = 5000, retries = 1, version = "1.0", loadbalance = "random", actives = 10)
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }
}
