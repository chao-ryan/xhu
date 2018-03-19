package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/18 22:09
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author dengchao
 * @ClassName College
 * @Description 学院信息表-实体
 * @date 2018/3/18
 */
public class College {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * name 学院名称
     */
    private String name;
    /**
     * studentsNumber 学生人数
     */
    private Integer studentsNumber;
    /**
     * teachersNumber 教师人数
     */
    private Integer teachersNumber;
    /**
     * saveTime 创建时间 yyyy-MM-dd HH:mm:ss
     */
    private Date saveTime;
    /**
     * updateTime 更新时间 yyyy-MM-dd HH:mm:ss
     */
    private Date updateTime;

    /**
     * @Title: College
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/18
     */
    public College(){

    }

    public College(Long id, String name, Integer studentsNumber, Integer teachersNumber, Date saveTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.studentsNumber = studentsNumber;
        this.teachersNumber = teachersNumber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(Integer studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    public Integer getTeachersNumber() {
        return teachersNumber;
    }

    public void setTeachersNumber(Integer teachersNumber) {
        this.teachersNumber = teachersNumber;
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