package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/18 21:54
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author dengchao
 * @ClassName ClassInfo
 * @Description 班级信息表-实体
 * @date 2018/3/18
 */
public class ClassInfo {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * number 班级编号
     */
    private String number;
    /**
     * name 班级名称
     */
    private String name;
    /**
     * studentsNumber 学生人数
     */
    private Integer studentsNumber;
    /**
     * teachersId 辅导员外键（一对一）
     */
    private Teachers teachersId;
    /**
     * saveTime 添加时间
     */
    private Date saveTime;
    /**
     * updateTime 更新时间
     */
    private Date updateTime;

    /**
     * @Title: ClassInfo
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/18
     */
    public ClassInfo(){

    }

    public ClassInfo(Long id, String number, String name, Integer studentsNumber, Teachers teachersId, Date saveTime, Date updateTime) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.studentsNumber = studentsNumber;
        this.teachersId = teachersId;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Teachers getTeachersId() {
        return teachersId;
    }

    public void setTeachersId(Teachers teachersId) {
        this.teachersId = teachersId;
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