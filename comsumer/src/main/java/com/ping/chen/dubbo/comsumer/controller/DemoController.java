package com.ping.chen.dubbo.comsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.ping.chen.dubbo.provider.DemoProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

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
    public void demo() throws ExecutionException, InterruptedException {
        demoProvider.sayHello("world");
        System.out.println(">>>>>>>>>>" + RpcContext.getContext().getFuture().get());
    }
}
