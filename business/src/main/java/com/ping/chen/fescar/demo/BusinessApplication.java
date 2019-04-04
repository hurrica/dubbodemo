package com.ping.chen.fescar.demo;

import com.ping.chen.dubbo.provider.fescar.BusinessService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
public class BusinessApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-business.xml"});
        BusinessService service = context.getBean(BusinessService.class);
        service.purchase("U100001", "C00321", 2);

    }
}
