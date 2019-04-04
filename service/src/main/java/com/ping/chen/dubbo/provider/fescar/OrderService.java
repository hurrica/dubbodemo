package com.ping.chen.dubbo.provider.fescar;

import com.ping.chen.dubbo.provider.model.fescal.Order;

/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
public interface OrderService {
    /**
     * 创建订单
     *
     * @param userId        用户ID
     * @param commodityCode 商品编号
     * @param orderCount    订购数量
     * @return 生成的订单 order
     */
    Order create(String userId, String commodityCode, int orderCount);
}
