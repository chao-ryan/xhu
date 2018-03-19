package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/18 22:14
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author dengchao
 * @ClassName Teachers
 * @Description 教师信息表-实体
 * @date 2018/3/18
 */
public class Teachers {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * name 教师姓名
     */
    private String name;
    /**
     * sex 教师性别 0-女，1-男
     */
    private Byte sex;
    /**
     * age 教师年龄
     */
    private Integer age;
    /**
     * origin 籍贯
     */
    private String origin;
    /**
     * enthnic 民族
     */
    private String enthnic;
    /**
     * idNumber 身份证号
     */
    private String idNumber;
    /**
     * phone 手机号
     */
    private String phone;
    /**
     * salary 工资
     */
    private Double salary;
    /**
     * collegeId 学院外键（多对一）
     */
    private College collegeId;
    /**
     * jobTitleId 教师职称外键（多对一）
     */
    private JobTitle jobTitleId;
    /**
     * saveTime 录入时间 yyyy-MM-dd HH:mm:ss
     */
    private Date saveTime;
    /**
     * updateTime 更新时间 yyyy-MM-dd HH:mm:ss
     */
    private Date updateTime;

    /**
     * @Title: Teachers
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/18
     */
    public Teachers(){

    }

    public Teachers(Long id, String name, Byte sex, Integer age, String origin, String enthnic, String idNumber, String phone, Double salary, College collegeId, JobTitle jobTitleId, Date saveTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.origin = origin;
        this.enthnic = enthnic;
        this.idNumber = idNumber;
        this.phone = phone;
        this.salary = salary;
        this.collegeId = collegeId;
        this.jobTitleId = jobTitleId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEnthnic() {
        return enthnic;
    }

    public void setEnthnic(String enthnic) {
        this.enthnic = enthnic;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public College getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(College collegeId) {
        this.collegeId = collegeId;
    }

    public JobTitle getJobTitleId() {
        return jobTitleId;
    }

    public void setJobTitleId(JobTitle jobTitleId) {
        this.jobTitleId = jobTitleId;
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