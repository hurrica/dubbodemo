package com.ping.chen.dubbo.comsumer;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.rpc.RpcContext;
import com.ping.chen.dubbo.provider.DemoProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutionException;

/**
 * Created by ping.chen on 2018/7/1.
 */
@SpringBootApplication
@DubboComponentScan("com.ping.chen.META-INF.comsumer")
public class ConsumerApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);

        // obtain proxy object for remote invocation
        DemoProvider demoProvider = (DemoProvider) context.getBean(DemoProvider.class);
        // execute remote invocation
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(demoProvider.sayHello("world"));
        String result = (String) RpcContext.getContext().getFuture().get();
        System.out.println(result);
        System.out.println("-----------------------------------------------------------------------");
    }
}
