package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/18 21:34
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author dengchao
 * @ClassName Account
 * @Description 学号信息表-实体
 * @date 2018/3/18
 */
public class Account {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * accountNumber 学生学号/账号
     */
    private String accountNumber;
    /**
     * password 密码
     */
    private String password;
    /**
     * saveTime 保存时间 yyyy-MM-dd HH:mm:ss
     */
    private Date saveTime;
    /**
     * updateTime 更新时间 yyyy-MM-dd HH:mm:ss
     */
    private Date updateTime;

    /**
     * @Title: Account
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/18
     */
    public Account(){

    }

    public Account(Long id, String accountNumber, String password, Date saveTime, Date updateTime) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.password = password;
        this.saveTime = saveTime;
        this.updateTime = updateTime;
    }

    /**
     * @Title: getter/setter
     * @Description: 封装
     * @author dengchao
     * @date 2018/3/18
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}