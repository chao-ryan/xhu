package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/15 22:15
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @ClassName Test
 * @Description 测试用的
 * @date 2018/3/15
 */
public class Test {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * name 姓名
     */
    private String name;

    /**
     * @Title: Test
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/15
     */
    public Test(){

    }

    public Test(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @Title: getter/setter
     * @Description: 封装
     * @author dengchao
     * @date 2018/3/15
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}