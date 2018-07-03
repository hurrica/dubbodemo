package com.ping.chen.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ping.chen.dubbo.service.DemoService;

/**
 * Created by ping.chen on 2018/7/1.
 */
@Service(timeout = 5000, retries = 0)
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
