package com.ping.chen.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ping.chen.dubbo.provider.DemoProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenping
 * @Description test
 * @Date 2019/4/3
 **/
@RestController
public class DemoController {
    @Reference(timeout = 5000)
    DemoProvider demoProvider;

    @RequestMapping("/demo")
    public void demo() {
        System.out.println(">>>>>>>>>>" + demoProvider.sayHello("world"));
    }
}
