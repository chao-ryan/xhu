package com.util;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.util
 * @author dengchao
 * @date 2018/3/18 22:51
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dengchao
 * @ClassName FormatUtils
 * @Description 类描述
 * @date 2018/3/18
 */
public class FormatUtils {
    /**
     * dateFormat 日期格式化 yyyy-MM-dd
     */
    private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    /**
     * dateTimeFormat 日期时间格式化 yyyy-MM-dd HH:mm:ss
     */
    private static SimpleDateFormat dateTimeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * timeFormat 时间格式化 HH:mm:ss
     */
    private static SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");


    /**
     * @Title: dateTimeFormat
     * @Description: 日期时间格式化
     * @author dengchao
     * @date 2018/3/18
     */
    public static String dateTimeFormat(Date date){
        System.out.println("121");
        if(date==null){
            System.out.println("122");
            return null;
        }else {
            System.out.println("1223");
            return dateTimeFormat.format(date);
        }
    }

    /**
     * @Title: dateFormat
     * @Description: 日期格式化
     * @author dengchao
     * @date 2018/3/18
     */
    public static String dateFormat(Date date){
        return dateFormat.format(date);
    }
    /**
     * @Title: timeFormat
     * @Description: 时间格式化
     * @author dengchao
     * @date 2018/3/18
     */
    public static String timeFormat(Date date){
        return timeFormat.format(date);
    }

    /**
     * @Title: dateFromStr
     * @Description: 字符串转为Date
     * @author dengchao
     * @date 2018/3/18
     */
    public static Date dateFromStr(String dateStr) throws ParseException {
        Date date=dateTimeFormat.parse(dateStr);
        return date;
    }

    /**
     * @Title: now
     * @Description: 获取当前系统时间并格式化输出
     * @author dengchao
     * @date 2018/3/18
     */
    public static Date now() throws ParseException {
        Date date=new Date();
        String nowStr=dateTimeFormat(date);
        Date now=dateTimeFormat.parse(nowStr);
        return now;
    }
}