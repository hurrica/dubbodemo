package com.ping.chen.fescar.demo.impl;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.ping.chen.dubbo.provider.fescar.BusinessService;
import com.ping.chen.dubbo.provider.fescar.OrderService;
import com.ping.chen.dubbo.provider.fescar.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
public class BusinessServiceImpl implements BusinessService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

    private StorageService storageService;

    private OrderService orderService;

    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-demo-tx")
    public void purchase(String userId, String commodityCode, int orderCount) {
        LOGGER.info("purchase begin ... xid: " + RootContext.getXID());
        storageService.deduct(commodityCode, orderCount);
        orderService.create(userId, commodityCode, orderCount);
        //throw new RuntimeException("xxx");
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
