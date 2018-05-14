package com.action;/********************************************************************
 /**
 * @Project: yuesuke
 * @Package com.action
 * @author dengchao
 * @date 2018/5/12 15:28
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.domain.Account;
import com.service.AccountService;
import com.util.FormatUtils;
import com.util.base.BaseAction;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName PasswordUpdateAction
 * @Description 信息管理-密码修改
 * @date 2018/5/12
 */
@Action(value = "passwordUpdate")
@Results({
        @Result(name = "success",location = "/jsp/passwordUpdatePage.jsp"),
        @Result(name = "failed",location = "/jsp/404.jsp")
})
public class PasswordUpdateAction extends BaseAction {
    @Autowired
    private AccountService accountService;

    private String update_username;

    private String update_oldpassword;

    private String update_newpassword;

    private Account account=null;

    public String updatePwd() throws UnsupportedEncodingException {
        //设置请求/响应编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String result="";
        Map<String,Object> mapAccount=new HashMap<String, Object>();
//        update_username=req.getParameter("update_username");
//        update_oldpassword=req.getParameter("update_username");
//        update_newpassword=req.getParameter("update_newpassword");

        if (update_username != null && !("".equals(update_username)) && //判断是否输入用户名
                update_oldpassword != null && !("".equals(update_oldpassword)) &&//判断是否输入原密码
                update_newpassword != null && !("".equals(update_newpassword))){//判断是否输入新密码
                    mapAccount.put("ACCOUNT_NUMBER", update_username);
                    if (accountService != null && mapAccount != null){
                        List<Account> accountList=accountService.findByCondition(mapAccount);
                        if (accountList.size() >0 && update_oldpassword.equals(accountList.get(0).getPassword())){
                            account=new Account();
                            account.setAccountNumber(update_username);
                            account.setPassword(update_newpassword);
                            try {
                                account.setUpdateTime(FormatUtils.now());
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            Integer rows=accountService.update(account);
                            if (rows > 0){//修改是否成功
                                req.setAttribute("pwdUpAccount",account);
                                result="success";
                            }else {
                                result="success";
                            }
                        }else {
                            result="success";
                        }
                    }else {
                        result="failed";
                    }
                }else {
            result="success";
        }
        return result;
    }


    public String getUpdate_username() {
        return update_username;
    }

    public void setUpdate_username(String update_username) {
        this.update_username = update_username;
    }

    public String getUpdate_oldpassword() {
        return update_oldpassword;
    }

    public void setUpdate_oldpassword(String update_oldpassword) {
        this.update_oldpassword = update_oldpassword;
    }

    public String getUpdate_newpassword() {
        return update_newpassword;
    }

    public void setUpdate_newpassword(String update_newpassword) {
        this.update_newpassword = update_newpassword;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}