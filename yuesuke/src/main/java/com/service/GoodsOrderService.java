package com.service;
/**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/3/28
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.GoodsOrder;

import java.util.List;

/**
 * @author dengchao
 * @InterfaceName GoodsOrderService
 * @Description 接口描述
 * @date 2018/3/28
 */
public interface GoodsOrderService {
    /**
     * @Title: findGoodsOrderById
     * @Description: 方法描述
     * @author dengchao
     * @date 2018/3/28
     * @param: id 指定id
     */
    public GoodsOrder findGoodsOrderById(Long id);

    /**
     * @return 受影响的行
     * @Title addGoodsOrderById
     * @Description 根据ID增加订单信息
     * @author dengchao
     * @date 2018/3/28
     * @param: id 指定id
     * @param: connection 连接对象
     */
    public Integer saveGoodsOrderById(GoodsOrder goodsOrder);

    /**
     * @return 受影响的行
     * @Title 修改订单信息
     * @Description
     * @author dengchao
     * @date 2018/3/28
     * @param: id 指定id
     * @param: goodsOrder 订单信息
     */
    public Integer updateGoodsOrder(GoodsOrder goodsOrder);

    /**
     * @Title: showGoodsOrder
     * @Description: 查看订单信息
     * @author dengchao
     * @date 2018/3/28
     * @param: goodsOrder 订单实体
     */
    public void showGoodsOrder(GoodsOrder goodsOrder);

    /**
     * @Title: findGoodsOrderByNum
     * @Description: 查过订单编号查询订单
     * @author dengchao
     * @date 2018/3/28
     * @param: goodsNum 商品编号
     * @return:
     */

    public GoodsOrder findGoodsOrderByNum(String goodsNum);

    /**
     * @Title: findGoodsOrderByPeopleId
     * @Description: 获取订单信息通过人员id
     * @author dengchao
     * @date 2018/3/28
     * @param: peopleId指定人员id
     * @return: 订单信息集合
     */
    public List<GoodsOrder> findGoodsOrderByPeopleId(Long peopleId);
}
