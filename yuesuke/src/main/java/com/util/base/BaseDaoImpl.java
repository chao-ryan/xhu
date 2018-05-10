package com.util.base;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.base
 * @author dengchao
 * @date 2018/3/15
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author dengchao
 * @ClassName BaseDaoImpl
 * @Description 类描述
 * @date 2018/3/15
 */
public class BaseDaoImpl<T> {

    @Resource
    protected SqlSessionTemplate sqlSessionTemplate;

    //获取T的Class对象是关键，看构造方法
    private Class<T> cls = null;


    public BaseDaoImpl() {

        Class cla=this.getClass();
        ParameterizedType type= (ParameterizedType) cla.getGenericSuperclass();
        Type[] types=type.getActualTypeArguments();
        cls= (Class<T>) types[0];
    }
    /**
     * @Title: getMybaitsNameSpace
     * @Description: 命名空间+“.”+id
     * @author dengchao
     * @date 2018/3/15
     */
    public String getMybaitsNameSpace(){
        return cls.getName()+".";
    }
}
