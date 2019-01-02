package com.huilong.cloud.dragon.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhanghuilong
 * @desc
 * @since 2018/12/27
 */
public class DragonInvocationHandler  implements InvocationHandler {

    private Object interfaceService;

    public DragonInvocationHandler(Object interfaceService) {
        this.interfaceService = interfaceService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy = [" + proxy + "], method = [" + method + "], args = [" + args + "]");


        return method.invoke(interfaceService, args);
    }
}
