package com.service;
/**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/3/29
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import com.dao.LogisticsGobyDao;
import com.domain.LogisticsGoby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dengchao
 * @ClassName LogisticsGobyServiceImpl
 * @Description 类的描述
 * @date 2018/3/29
 */
@Service("logisticsGobyService")
@Transactional
public class LogisticsGobyServiceImpl implements LogisticsGobyService{

    @Autowired
    private LogisticsGobyDao logisticsGobyDao;

    /**
     * @param logisticsInfoId 物流信息 主键id
     * @return List<LogisticsGoby.xml> 返回物流过程的集合
     * @Title: findLogisticsGobyLogisticsnfoId
     * @Description: 通过传入 logisticsInfoId（物流信息 主键id）查询物流过程实体
     * @author dengchao
     * @date 2018/3/29
     */
    @Override
    public List<LogisticsGoby> findLogisticsGobyLogisticsnfoId(Long logisticsInfoId) {
        return logisticsGobyDao.findLogisticsGobyLogisticsnfoId(logisticsInfoId);
    }

    /**
     * @param logisticsGoby 物流过程实体
     * @return Integer 返回受影响的行数
     * @Title: saveLogisticsGoby
     * @Description: 添加物流过程实体
     * @author dengchao
     * @date 2018/3/29
     */
    @Override
    public Integer saveLogisticsGoby(LogisticsGoby logisticsGoby) {
        return logisticsGobyDao.saveLogisticsGoby(logisticsGoby);
    }

    /**
     * @param logisticsGoby 物流过程实体
     * @return Integer 受影响的行数
     * @Title: deleteLogisticsGobyById
     * @Description: 删除物流过程
     * @author dengchao
     * @date 2018/3/29
     */
    @Override
    public Integer deleteLogisticsGobyById(LogisticsGoby logisticsGoby) {
        return logisticsGobyDao.deleteLogisticsGobyById(logisticsGoby);
    }

    /**
     * @param logisticsGoby 物流信息实体
     * @return Integer 受影响的行数
     * @Title: updateLogisticsGobyId
     * @Description: 更新物流信息
     * @author dengchao
     * @date 2018/3/29
     */
    @Override
    public Integer updateLogisticsGobyId(LogisticsGoby logisticsGoby) {
        return logisticsGobyDao.updateLogisticsGobyId(logisticsGoby);
    }
}
