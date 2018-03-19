package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/18 21:41
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @ClassName JobTitle
 * @Description 教师职称表-实体
 * @date 2018/3/18
 */
public class JobTitle {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * jobName 职称
     */
    private String jobName;

    /**
     * @Title: JobTitle
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/18
     */
    public JobTitle(){

    }

    public JobTitle(Long id, String jobName) {
        this.id = id;
        this.jobName = jobName;
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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}