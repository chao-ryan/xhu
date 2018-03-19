package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/18 22:23
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.Date;

/**
 * @author dengchao
 * @ClassName Students
 * @Description 学生个人信息表-实体
 * @date 2018/3/18
 */
public class Students {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * name 学生姓名
     */
    private String name;
    /**
     * sex 学生性别 0-女,1-男
     */
    private Byte sex;
    /**
     * birthday 出生年月日 yyyy-MM-dd
     */
    private Date birthday;
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
     * university 学校名字
     */
    private String university;
    /**
     * achievement 高考成绩
     */
    private Double achievement;
    /**
     * phone 手机号
     */
    private String phone;
    /**
     * fatherName 父亲姓名
     */
    private String fatherName;
    /**
     * fatherPhone 父亲联系方式
     */
    private String fatherPhone;
    /**
     * fatherAddress 父亲现居地
     */
    private String fatherAddress;
    /**
     * motherName 母亲姓名
     */
    private String motherName;
    /**
     * motherPhone 母亲联系方式
     */
    private String motherPhone;
    /**
     * motherAddress 母亲现居地
     */
    private String motherAddress;
    /**
     * familyPopulation 家庭人口
     */
    private Integer familyPopulation;
    /**
     * roomId 宿舍外键（多对一）
     */
    private Room roomId;
    /**
     * accountId 学生学号/账号外键（一对一）
     */
    private Account accountId;
    /**
     * saveTime 保存时间 yyyy-MM-dd HH:mm:ss
     */
    private Date saveTime;
    /**
     * updateTime 更新时间 yyyy-MM-dd HH:mm:ss
     */
    private Date updateTime;

    /**
     * @Title: Students
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/18
     */
    public Students(){

    }

    public Students(Long id, String name, Byte sex, Date birthday, String origin, String enthnic, String idNumber, String university, Double achievement, String phone, String fatherName, String fatherPhone, String fatherAddress, String motherName, String motherPhone, String motherAddress, Integer familyPopulation, Room roomId, Account accountId, Date saveTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.origin = origin;
        this.enthnic = enthnic;
        this.idNumber = idNumber;
        this.university = university;
        this.achievement = achievement;
        this.phone = phone;
        this.fatherName = fatherName;
        this.fatherPhone = fatherPhone;
        this.fatherAddress = fatherAddress;
        this.motherName = motherName;
        this.motherPhone = motherPhone;
        this.motherAddress = motherAddress;
        this.familyPopulation = familyPopulation;
        this.roomId = roomId;
        this.accountId = accountId;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Double getAchievement() {
        return achievement;
    }

    public void setAchievement(Double achievement) {
        this.achievement = achievement;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public String getFatherAddress() {
        return fatherAddress;
    }

    public void setFatherAddress(String fatherAddress) {
        this.fatherAddress = fatherAddress;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone;
    }

    public String getMotherAddress() {
        return motherAddress;
    }

    public void setMotherAddress(String motherAddress) {
        this.motherAddress = motherAddress;
    }

    public Integer getFamilyPopulation() {
        return familyPopulation;
    }

    public void setFamilyPopulation(Integer familyPopulation) {
        this.familyPopulation = familyPopulation;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
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