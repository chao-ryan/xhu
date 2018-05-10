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
import com.util.base.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName PeopleDaoImpl
 * @Description 人员数据库表 操作类，实现PeopleDao接口
 * @date 2018/3/27
 */
@Repository("peopleDao")
public class PeopleDaoImpl extends BaseDaoImpl<People> implements PeopleDao {

    /**
     * @Title: findPeopleById
     * @Description: 通过指定Id查找人员
     * @author dengchao
     * @date 2018/3/27
     * @param: id 指定id
     * @return: 人员对象
     */
    @Override
    public People findPeopleById(Long id) {
//        People people=new People();
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"getPoepleById",id);
//        return people;
    }

    /**
     * @Title: savePeople
     * @Description: 保存人员信息
     * @author dengchao
     * @date 2018/3/27
     * @param: people 人员对象
     * @return: 受影响行数
     */
    @Override
    public Integer savePeople(People people) {
        return this.sqlSessionTemplate.insert(getMybaitsNameSpace()+"savePeople",people);
    }
    /**
     * @Title: deletePeopleById
     * @Description: 删除指定id 的人员信息
     * @author dengchao
     * @date 2018/3/27
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deletePeopleById(Long id) {
        return this.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deletePeopleById",id);
//        return line;
    }

    /**
     * @Title: updatePeople
     * @Description: 更新指定人员的信息
     * @author dengchao
     * @date 2018/3/27
     * @param: id 指定人员id
     * @param: people 指定人员信息
     * @return: 受影响行数
     */
    @Override
    public Integer updatePeople(People people) {
        return this.sqlSessionTemplate.update(getMybaitsNameSpace()+"updatePeople",people);
//        return line;
    }

    /**
     * @Title: findPeopleByUserName
     * @Description: 查找用户根据用户名和密码
     * @author dengchao
     * @date 2018/3/27
     * @param: userName 用户名
     * @param: password 密码
     * @return: 人员对象
     */
    @Override
    public People findPeopleByUserName(String userName, String password) {
        Map userMap=new HashMap();
        userMap.put("usreName",userName);
        userMap.put("passWord",password);
//        People people=new People();
        return this.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"findPeopleByUserName",userMap);
//        return people;
    }

    public List<People> getAllPeople(){
        List<People> peopleList=this.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"getAllPeople");
        return peopleList;
    }

}
