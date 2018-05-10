package com.dao;
/**
 * @Project: yuesuke
 * @Package com.dao
 * @author dengchao
 * @date 2018/3/27
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.People;

import java.util.List;

/**
 * @author dengchao
 * @InterfaceName PeopleDao
 * @Description 人员数据库表 接口
 * @date 2018/3/27
 */
public interface PeopleDao {


    /**
     * @Title: findPeopleById
     * @Description: 通过指定Id查找人员
     * @author dengchao
     * @date 2018/3/27
     * @param: id 指定id
     * @return: 人员对象
     */
    public People findPeopleById(Long id);

    /**
     * @Title: savePeople
     * @Description: 保存人员信息
     * @author dengchao
     * @date 2018/3/27
     * @param: people 人员对象
     * @return: 受影响行数
     */
    public Integer savePeople(People people);

    /**
     * @Title: deletePeopleById
     * @Description: 删除指定id 的人员信息
     * @author dengchao
     * @date 2018/3/27
     * @param: id 指定id
     * @return: 受影响行数
     */
    public Integer deletePeopleById(Long id);

    /**
     * @Title: updatePeople
     * @Description: 更新指定人员的信息
     * @author dengchao
     * @date 2018/3/27
     * @param: id 指定人员id
     * @param: people 指定人员信息
     * @return: 受影响行数
     */
    public Integer updatePeople(People people);

    /**
     * @Title: findPeopleByUserName
     * @Description: 查找用户根据用户名和密码
     * @author dengchao
     * @date 2018/3/27
     * @param: userName 用户名
     * @param: password 密码
     * @return: 人员对象
     */
    public People findPeopleByUserName(String userName, String password);


    public List<People> getAllPeople();


//
//    public List<People> getPeopleAll();
//    /**
//     * @Title: findPeopleById
//     * @Description: 通过指定Id查找人员
//     * @author dengchao
//     * @date 2018/3/27
//     * @throws: SQLException
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement对象
//     * @return: 人员对象
//     */
//    public People findPeopleById(Long id) throws SQLException;
//
//    /**
//     * @Title: findPeopleByUserName
//     * @Description: 查找用户根据用户名和密码
//     * @author dengchao
//     * @date 2018/3/27
//     * @param: userName 用户名
//     * @param: password 密码
//     * @return: 人员对象
//     */
//    public People findPeopleByUserName(String userName,String password) throws SQLException;
//    /**
//     * @Title: savePeople
//     * @Description: 插入人员信息
//     * @author dengchao
//     * @date 2018/3/27
//     * @throw SQLException
//     * @param: people 人员信息
//     * @param: connection 连接对象
//     * @param: preparedStatement 预编译Statement
//     * @return: 受影响行数
//     */
//    public Integer savePeople(People people, Connection connection, PreparedStatement preparedStatement) throws SQLException;
//
//    /**
//     * @Title: deletePeopleById
//     * @Description: 删除指定id 的人员信息
//     * @author dengchao
//     * @date 2018/3/27
//     * @param: id 指定id
//     * @param: connection 连接对象
//     * @param: prepareStatement 预编译 Statement对象
//     * @return: 受影响行数
//     */
//    public Integer deletePeopleById(Long id, Connection connection, PreparedStatement prepareStatement) throws SQLException;
//
//    /**
//     * @Title: updatePeopleById
//     * @Description: 更新指定人员的信息
//     * @author dengchao
//     * @date 2018/3/27
//     * @param: id 指定人员id
//     * @param: people 指定人员信息
//     * @param: connection 连接对象
//     * @param: prepareStatement 预编译 Statement对象
//     * @return: 受影响行数
//     */
//    public Integer updatePeopleById(Long id, People people, Connection connection, PreparedStatement prepareStatement)
//            throws SQLException;
//    /**
//     * @Title: findPeopleByUnSureCondition
//     * @Description: 方法描述
//     * @author dengchao
//     * @date 2018/3/27
//     * @param map 条件和值对应key和value
//     * @param connection 连接对象
//     * @param prepareStatement 预编译 Statement对象
//     * @throw SQLException
//     */
//    public List<People> findPeopleByUnSureCondition(List<Map<String,Object>> map,Connection connection, PreparedStatement prepareStatement)
//        throws SQLException;
}
