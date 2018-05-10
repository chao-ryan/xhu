package com.service;
/**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/4/20
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */
import com.domain.GoodsOrder;
import com.domain.OrderDetail;

import java.util.List;

/**
 * @author dengchao
 * @InterfaceName OrderDetailService
 * @Description 订单详情service接口
 * @date 2018/4/20
 */
public interface OrderDetailService {
    /**
     * @Title: saveOrderDetail
     * @Description: 新增订单详情信息
     * @author dengchao
     * @date 2018/4/20
     * @throw SQLException
     * @param: people 人员信息
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 受影响行数
     */
    public OrderDetail findOrderDetailById(Long id);

    /**
     * @Title: saveOrderDetail
     * @Description: 新增订单详情信息
     * @author dengchao
     * @date 2018/4/20
     * @throw SQLException
     * @param: people 人员信息
     * @param: connection 连接对象
     * @param: preparedStatement 预编译Statement
     * @return: 受影响行数
     */
    public Integer saveOrderDetail(OrderDetail orderDetail);


    /**
     * @Title: updateOrderDetailById
     * @Description: 更新指定订单详情的信息
     * @author dengchao
     * @date 2018/4/20
     * @param: id 指定人员id
     * @param: orderDetail 指定订单详情
     * @param: connection 连接对象
     * @param: prepareStatement 预编译 Statement对象
     * @return: 受影响行数
     */
    public Integer updateOrderDetailById(Long id, OrderDetail orderDetail);

    /**
     * @Title: getGoodsDetailListByOrderId
     * @Description: 获取指定订单id 的订单详情
     * @author dengchao
     * @date 2018/4/20
     * @param: orderId 指定订单id
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailListByOrderId(Long orderId);

    /**
     * @Title: findOrderDetailByPeopleId
     * @Description: 通过商铺id查找订单详情
     * @author dengchao
     * @date 2018/4/20
     * @param: peopleId 指定人员id
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailByStoreId(Long storeId);

    /**
     * @Title: findOrderDetailByPeopleId
     * @Description: 通过人员id查找订单详情
     * @author dengchao
     * @date 2018/4/20
     * @param: peopleId 指定人员id
     * @return: 订单详情集合
     */
    public List<OrderDetail> findOrderDetailByPeopleId(Long peopleId);

    /**
     * @Title: showOrderDetailMessage
     * @Description: 订单详情查看
     * @author dengchao
     * @date 2018/4/20
     * @param: orderDetail 订单详情对象
     */

    public void showOrderDetailMessage(OrderDetail orderDetail);

    /**
     * @Title: findOrderDetailByOrderList
     * @Description: 查找指定List<GoodsOrder>的订单详情集合
     * @author dengchao
     * @date 2018/4/20
     * @param: goodsOrderList 指定List<GoodsOrder>
     * @return:  List<OrderDetail>
     */
    public List<OrderDetail> findOrderDetailByOrderList(List<GoodsOrder> goodsOrderList);
}