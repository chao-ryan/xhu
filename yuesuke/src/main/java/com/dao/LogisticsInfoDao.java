package com.dao;
/**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/3/24 22:44
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.LogisticsInfo;

import java.util.List;

/**
 * @author dengchao
 * @ClassName LogisticsInfoDao
 * @Description 物流信息表数据库操作接口
 * @date 2018/3/24
 */
public interface LogisticsInfoDao {
    /**
     * @Title: findLogisticsInfoByOrderDetailId
     * @Description: 通过传入orderDetailId（订单详情 主键id）查询物流信息实体
     * @author dengchao
     * @date 2018/3/24
     * @param OrderDetailId 订单详情 主键id
     * @return LogisticsInfo 物流信息实体
     *
     */
    public LogisticsInfo findLogisticsInfoByOrderDetailId(Long OrderDetailId);

    /**
     * @Title: findLogisticsInfoAll
     * @Description: 查询所有的物流信息
     * @author dengchao
     * @date 2018/3/24
     * @param
     * @return List<LogisticsInfo> 物流信息实体的集合
     *
     */
    public List<LogisticsInfo> findLogisticsInfoAll();

    /**
     * @Title: saveLogisticsInfo
     * @Description: 添加物流信息实体
     * @author dengchao
     * @date 2018/3/24
     * @param logisticsInfo 物流信息实体
     * @return Integer 返回受影响的行数
     *
     */
    public Integer saveLogisticsInfo(LogisticsInfo logisticsInfo);

    /**
     * @Title: deleteLogisticsInfoById
     * @Description: 删除物流信息
     * @author dengchao
     * @date 2018/3/24
     * @param logisticsInfo 主键id
     * @return Integer 受影响的行数
     * 
     */
    public Integer deleteLogisticsInfoById(LogisticsInfo logisticsInfo);

    /**
     * @Title: updateLogisticsInfoByOrderDetailId
     * @Description: 更新物流信息
     * @author dengchao
     * @date 2018/3/24
     * @param logisticsInfo 物流信息实体
     * @return Integer 受影响的行数
     *
     */
    public Integer updateLogisticsInfoByOrderDetailId(LogisticsInfo logisticsInfo);

}
