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
 * @ClassName PersonException
 * @Description 购买商品 异常
 * @date 2018/4/20
 */
public class PeopleException extends Exception {
    //构造器
    public PeopleException() {
        super();
    }

    public PeopleException(String exceptionMessage) {
        super(exceptionMessage);
    }
}