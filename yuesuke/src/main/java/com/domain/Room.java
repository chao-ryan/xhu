package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/18 21:45
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @ClassName Room
 * @Description 学生宿舍信息表-实体
 * @date 2018/3/18
 */
public class Room {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * address 宿舍地址
     */
    private String address;
    /**
     * auntieName 宿管阿姨姓名
     */
    private String auntieName;
    /**
     * studentsNumber 学生人数
     */
    private Integer studentsNumber;
    /**
     * emptyRoom 空房间数
     */
    private Integer emptyRoom;
    /**
     * isFull 是否已入住满 1-是(默认),0-否
     */
    private Byte isFull;

    /**
     * @Title: Room
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/18
     */
    public Room(){

    }

    public Room(Long id, String address, String auntieName, Integer studentsNumber, Integer emptyRoom, Byte isFull) {
        this.id = id;
        this.address = address;
        this.auntieName = auntieName;
        this.studentsNumber = studentsNumber;
        this.emptyRoom = emptyRoom;
        this.isFull = isFull;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuntieName() {
        return auntieName;
    }

    public void setAuntieName(String auntieName) {
        this.auntieName = auntieName;
    }

    public Integer getStudentsNumber() {
        return studentsNumber;
    }

    public void setStudentsNumber(Integer studentsNumber) {
        this.studentsNumber = studentsNumber;
    }

    public Integer getEmptyRoom() {
        return emptyRoom;
    }

    public void setEmptyRoom(Integer emptyRoom) {
        this.emptyRoom = emptyRoom;
    }

    public Byte getIsFull() {
        return isFull;
    }

    public void setIsFull(Byte isFull) {
        this.isFull = isFull;
    }
}