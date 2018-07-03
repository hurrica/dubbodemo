package com.ping.chen.dubbo.comsumer;

import com.ping.chen.dubbo.service.DemoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ping.chen on 2018/7/1.
 */
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"consumer.xml"});
        context.start();
        // obtain proxy object for remote invocation
        DemoService demoService = (DemoService) context.getBean("demoService");
        // execute remote invocation
        System.out.println("-----------------------------------------------------------------------");
        long startTime = System.currentTimeMillis();
        System.out.println("ready to request");
        String hello = demoService.sayHello("world");
        Long endTime = System.currentTimeMillis();
        System.out.println(hello);
        System.out.println("time1: " + (endTime-startTime));

        System.out.println(demoService.sayHello("ping"));
        System.out.println(System.currentTimeMillis() - endTime);
        System.out.println("-----------------------------------------------------------------------");

    }
}
