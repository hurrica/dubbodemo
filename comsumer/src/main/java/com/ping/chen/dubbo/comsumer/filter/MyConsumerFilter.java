package com.ping.chen.dubbo.comsumer.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * @Author chenping
 * @Description rpc dubbo
 * @Date 2019/4/3
 **/
@Activate(group = Constants.CONSUMER)
public class MyConsumerFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //避免RpcContext透传,使用配置文件的async
        boolean isAsync = invoker.getUrl().getMethodParameter(invocation.getMethodName(), Constants.ASYNC_KEY, false);
        RpcContext.getContext().setAttachment(Constants.ASYNC_KEY, String.valueOf(isAsync));
        return invoker.invoke(invocation);
    }
}
