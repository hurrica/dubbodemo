package com.ping.chen.fescar.demo.starter;

import com.ping.chen.fescar.demo.ApplicationKeeper;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
@DubboComponentScan("com.ping.chen.fescar.demo.service")
public class DubboOrderServiceStarter {
    public static void main(String[] args) {
        /**
         *  3. Order service is ready . Waiting for buyers to order
         */
        ClassPathXmlApplicationContext orderContext = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-order-service.xml"});
        new ApplicationKeeper(orderContext).keep();
    }
}
