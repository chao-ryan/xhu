package com.domain;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.domain
 * @author dengchao
 * @date 2018/3/18 22:04
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/**
 * @author dengchao
 * @ClassName ClassRelation
 * @Description 班级关系表-实体
 * @date 2018/3/18
 */
public class ClassRelation {
    /**
     * id 主键id
     */
    private Long id;
    /**
     * grade 年级
     */
    private String grade;
    /**
     * collegeId 学院外键
     */
    private College collegeId;
    /**
     * classInfoId 班级信息外键
     */
    private ClassInfo classInfoId;
    /**
     * studentsId 学生信息外键
     */
    private Students studentsId;

    /**
     * @Title: ClassRelation
     * @Description: 构造器
     * @author dengchao
     * @date 2018/3/18
     */
    public ClassRelation(){

    }

    public ClassRelation(Long id, String grade, College collegeId, ClassInfo classInfoId, Students studentsId) {
        this.id = id;
        this.grade = grade;
        this.collegeId = collegeId;
        this.classInfoId = classInfoId;
        this.studentsId = studentsId;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public College getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(College collegeId) {
        this.collegeId = collegeId;
    }

    public ClassInfo getClassInfoId() {
        return classInfoId;
    }

    public void setClassInfoId(ClassInfo classInfoId) {
        this.classInfoId = classInfoId;
    }

    public Students getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(Students studentsId) {
        this.studentsId = studentsId;
    }
}