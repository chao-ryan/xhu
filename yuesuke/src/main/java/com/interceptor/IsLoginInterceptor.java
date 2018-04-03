package com.interceptor;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.interceptor
 * @author dengchao
 * @date 2018/4/3 21:47
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author dengchao
 * @ClassName IsLoginInterceptor
 * @Description 拦截器
 * @date 2018/4/3
 */
public class IsLoginInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("拦截成功");
        return actionInvocation.invoke();
    }
}