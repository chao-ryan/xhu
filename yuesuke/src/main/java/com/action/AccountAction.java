package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/5 13:24
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Account;
import com.service.AccountServiceImpl;
import com.util.FormatUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName AccountAction
 * @Description 类描述
 * @date 2018/5/5
 */
@Action(value = "account")
@Results({
        @Result(name = "testAccount",location = "/jsp/404.jsp")
})
public class AccountAction {
    @Autowired
    private AccountServiceImpl accountService;
    public void testAccount(){
        if (accountService != null){
            try {
                Account account=new Account();
                account.setId(12l);
                account.setAccountNumber("D201855");
                account.setPassword("ryan");
                account.setSaveTime(FormatUtils.now());
                account.setUpdateTime(FormatUtils.now());
                Map<String,Object> objectMap=new HashMap<String, Object>();
                objectMap.put("ACCOUNT_NUMBER", account.getAccountNumber());
                //
                accountService.save(account);
                System.out.println("SUCCEED");
            } catch (ParseException e) {
                System.out.println("时间类型转换异常");
                e.printStackTrace();
            }
        }else {
            System.out.println("accountService 为空");
        }

    }
}