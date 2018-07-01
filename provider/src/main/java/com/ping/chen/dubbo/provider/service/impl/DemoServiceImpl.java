package com.ping.chen.dubbo.provider.service.impl;

import com.ping.chen.dubbo.provider.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * Created by ping.chen on 2018/7/1.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
