package com.service;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/4/20
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.PayFlow;

import java.util.List;
import java.util.Map;


/**
 * @author dengchao
 * @InterfaceName PayFlowService
 * @Description 流水接口
 * @date 2018/4/20
 */
public interface PayFlowService {

    /**
     * @Title: findPayFlowById
     * @Description: 通过id查找流水信息
     * @author dengchao
     * @date 2018/4/20
     * @param: id 指定id
     * @return: 流水信息
     */

    public PayFlow findPayFlowById(Long id);

    /**
     * @Title: findPayFlowById
     * @Description: 通过流水号查ID
     * @author dengchao
     * @date 2018/4/20
     * @param: id 指定id
     * @return: 流水信息
     */

    public PayFlow findPayFlowByFlowNum(String flowNum) throws RuntimeException;

    /**
     * @Title: savePayFlow
     * @Description: 保存流水信息
     * @author dengchao
     * @date 2018/4/20
     * @param: payFlow 流水信息
     * @return: 受影响行数
     */

    public int savePayFlow(PayFlow payFlow);

    /**
     * @param peopleId
     * @Title: MonthConsumption
     * @Description: 指定人员的当月消费情况
     * @author dengchao
     * @date 2018/4/20
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> MonthConsumption(Long peopleId);

    /**
     * @Title: MonthEarnings
     * @Description: 指定卖家的本月盈利
     * @author dengchao
     * @date 2018/4/20
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> MonthEarnings(Long storeId);

    /**
     * @Title: YearConsumption
     * @Description: 指定买家的本年消费
     * @author dengchao
     * @date 2018/4/20
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> YearConsumption(Long peopleId);

    /**
     * @Title: YearEarnings
     * @Description: 指定卖家的本年盈利
     * @author dengchao
     * @date 2018/4/20
     * @throw YnCorpSysException
     */
    public List<Map<String, Object>> YearEarnings(Long storeId);

}