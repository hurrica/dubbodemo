package com.ping.chen.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ping.chen.dubbo.provider.DemoProvider;

/**
 * Created by ping.chen on 2018/7/1.
 * 应该加上版本号，为后续不兼容升级提供可能
 * actives 每个消费者最大并发调用数
 *
 */
@Service(interfaceClass = DemoProvider.class)
public class DemoProviderImpl implements DemoProvider {

    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + name;
    }
}
