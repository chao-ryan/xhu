package com.util;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.util
 * @author dengchao
 * @date 2018/3/15
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AddConditionUtils
 * @Description 不确定条件查询中添加条件的帮助方法
 * @author dengchao
 * @date 2018/3/15
*/
public class AddConditionUtils {
    /**
     * @Title: addCondition
     * @Description: 添加条件
     * @author dengchao
     * @date 2018/3/15
     */
    public static Map<String,Object> addCondition(String str1,String str2,Object obj){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",str1);
        map.put("rela",str2);
        map.put("value",obj);
        return map;
    }
}