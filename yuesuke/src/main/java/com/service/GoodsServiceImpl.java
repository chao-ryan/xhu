package com.service;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.service
 * @author dengchao
 * @date 2018/3/28
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.dao.GoodsDao;
import com.domain.Goods;
import com.tools.GoodsTypeEnum;
import com.tools.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dengchao
 * @ClassName GoodsServiceImpl
 * @Description 商品 操作类 实现GoodsService 接口
 * @date 2018/3/28
 */
@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;// = new GoodsDaoImpl();
    /**
     * @Title: findGoodsById
     * @Description: 查找指定id商品信息
     * @author dengchao
     * @date 2018/3/28
     * @param: id 指定id
     * @return: 商品对象
     */
    @Override
    public Goods findGoodsById(Long id){
        return goodsDao.findGoodsById(id);
    }

    public List<Goods> findGoodsAll(){
        return goodsDao.findGoodsAll();
    }


    /**
     * @Title: saveGoods
     * @Description: 保存商品信息
     * @author dengchao
     * @date 2018/3/28
     * @param: goods 商品信息
     * @return: 受影响行数
     */
    @Override
    public Integer saveGoods(Goods goods){
        return goodsDao.saveGoods(goods);
    }


    /**
     * @Title: deleteGoodsById
     * @Description: 删除指定id的商品信息
     * @author dengchao
     * @date 2018/3/28
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteGoodsById(Long id) {
        return goodsDao.deleteGoodsById(id);
    }

    /**
     * @Title: updateGoodsById
     * @Description: 更新指定id商品信息
     * @author dengchao
     * @date 2018/3/28
     * @param: id 指定id
     * @param: goods 商品信息
     * @return: 受影响行数
     */
    @Override
    public Integer updateGoods(Goods goods){
        return goodsDao.updateGoods(goods);
    }


    /**
     * @Title: showGoods
     * @Description: 查看商品信息
     * @author dengchao
     * @date 2018/3/28
     * @param: goods 商品对象
     */
    @Override
    public void showGoods(Goods goods) {
        System.out.print("主键ID:" + goods.getId() + " ");
        System.out.print("商品编号:" + goods.getGoodsNum() + " ");
        System.out.print("名称:" + goods.getName() + " ");
        System.out.print("类型:" + GoodsTypeEnum.findGoodsTypeByIndex(goods.getType()) + " ");
        System.out.print("单位:" + goods.getUnit() + " ");
        System.out.print("生产时间:" + new TimeFormat(goods.getProcedureDate()).format() + " ");
        System.out.print("保质期:" + goods.getShelfLife() + " ");
        System.out.print("保质期单位:" + goods.getShelfLifeUnit() + " ");
        System.out.println();
    }

}