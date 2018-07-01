package com.ping.chen.dubbo.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ping.chen on 2018/7/1.
 */
@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"provider.xml"});
        context.start();
        // press any key to exit
        System.in.read();
    }
}
