package com.ping.chen.dubbo.provider.service.impl;

import com.ping.chen.dubbo.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by ping.chen on 2018/7/1.
 */
@Service
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
