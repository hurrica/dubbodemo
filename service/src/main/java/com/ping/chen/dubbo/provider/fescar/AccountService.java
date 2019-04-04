package com.ping.chen.dubbo.provider.fescar;

/**
 * @Author chenping
 * @Description
 * @Date 2019/4/4
 **/
public interface AccountService {
    /**
     * 余额扣款
     *
     * @param userId 用户ID
     * @param money  扣款金额
     */
    void debit(String userId, int money);

}
