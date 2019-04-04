package com.ping.chen.fescar.demo.controller;


import com.ping.chen.dubbo.provider.fescar.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenping
 * @Description test
 * @Date 2019/4/3
 **/
@RestController
public class DemoController {
    BusinessService businessService;

    @RequestMapping("/purchase")
    public String purchase(){
        businessService.purchase("U100001", "C00321", 2);
        return "success";
    }
}
