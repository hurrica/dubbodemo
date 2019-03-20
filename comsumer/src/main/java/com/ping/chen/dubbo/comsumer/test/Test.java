package com.ping.chen.dubbo.comsumer.test;

import com.alibaba.dubbo.rpc.RpcContext;

import java.util.concurrent.ExecutionException;

/**
 * @Author chenping
 * @Description test
 * @Date 2019/3/9
 **/
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RpcContext.getContext().getFuture().get();
    }

}
