package com.tools;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.tools
 * @author dengchao
 * @date 2018/4/20
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @ClassName GoodsException
 * @Description 类描述
 * @date 2018/4/20
 */
public class GoodsException extends Exception {
    //商品异常
    public GoodsException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public GoodsException() {
        super();
    }
}