package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/5/26 22:01
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @ClassName Schooling
 * @Description 学杂费表
 * @date 2018/5/26
 */
public class Schooling {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * bookFee 书本费
     */
    private Double bookFee;
    /**
     * tuitionFee 学费
     */
    private Double tuitionFee;
    /**
     * boardingFee 住宿费
     */
    private Double boardingFee;
    /**
     * otherFee 其他费用
     */
    private Double otherFee;
    /**
     * totalFee 总计
     */
    private Double totalMoney;

    /**
     * 构造器
     */
    public Schooling(){

    }

    public Schooling(Long id, Double bookFee, Double tuitionFee, Double boardingFee, Double otherFee, Double totalMoney) {
        this.id = id;
        this.bookFee = bookFee;
        this.tuitionFee = tuitionFee;
        this.boardingFee = boardingFee;
        this.otherFee = otherFee;
        this.totalMoney = totalMoney;
    }

    /**
     * setter/getter封装
     * @return
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBookFee() {
        return bookFee;
    }

    public void setBookFee(Double bookFee) {
        this.bookFee = bookFee;
    }

    public Double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(Double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public Double getBoardingFee() {
        return boardingFee;
    }

    public void setBoardingFee(Double boardingFee) {
        this.boardingFee = boardingFee;
    }

    public Double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Double otherFee) {
        this.otherFee = otherFee;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}