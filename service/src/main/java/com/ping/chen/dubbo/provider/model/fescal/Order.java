package com.ping.chen.dubbo.provider.model.fescal;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author chenping
 * @Description order
 * @Date 2019/4/4
 **/
@Data
public class Order implements Serializable {
    /**
     * The Id.
     */
    public long id;
    /**
     * The User id.
     */
    public String userId;
    /**
     * The Commodity code.
     */
    public String commodityCode;
    /**
     * The Count.
     */
    public int count;
    /**
     * The Money.
     */
    public int money;
}
