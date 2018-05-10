package com.service;
/**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/3/29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.domain.LogisticsGoby;

import java.util.List;

/**
 * @author dengchao
 * @ClassName LogisticsGobyService
 * @Description 类的描述
 * @date 2018/3/29
 */
public interface LogisticsGobyService {
    /**
     * @Title: findLogisticsGobyLogisticsnfoId
     * @Description: 通过传入 logisticsInfoId（物流信息 主键id）查询物流过程实体
     * @author dengchao
     * @date 2018/3/29
     * @param logisticsInfoId 物流信息 主键id
     * @return List<LogisticsGoby.xml> 返回物流过程的集合
     *
     */
    public List<LogisticsGoby> findLogisticsGobyLogisticsnfoId(Long logisticsInfoId);

    /**
     * @Title: saveLogisticsGoby
     * @Description: 添加物流过程实体
     * @author dengchao
     * @date 2018/3/29
     * @param logisticsGoby 物流过程实体
     * @return Integer 返回受影响的行数
     *
     */
    public Integer saveLogisticsGoby(LogisticsGoby logisticsGoby);

    /**
     * @Title: deleteLogisticsGobyById
     * @Description: 删除物流过程
     * @author dengchao
     * @date 2018/3/29
     * @param logisticsGoby 物流过程实体
     * @return Integer 受影响的行数
     *
     */
    public Integer deleteLogisticsGobyById(LogisticsGoby logisticsGoby);

    /**
     * @Title: updateLogisticsGobyId
     * @Description: 更新物流信息
     * @author dengchao
     * @date 2018/3/29
     * @param logisticsGoby 物流信息实体
     * @return Integer 受影响的行数
     *
     */
    public Integer updateLogisticsGobyId(LogisticsGoby logisticsGoby);
}
