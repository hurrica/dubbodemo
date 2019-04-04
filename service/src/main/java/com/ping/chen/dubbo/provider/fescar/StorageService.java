package com.ping.chen.dubbo.provider.fescar;

/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
public interface StorageService {
    /**
     * 扣减库存
     *
     * @param commodityCode 商品编号
     * @param count         扣减数量
     */
    void deduct(String commodityCode, int count);
}
