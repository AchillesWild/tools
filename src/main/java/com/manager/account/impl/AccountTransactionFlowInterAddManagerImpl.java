package com.manager.account.impl;

import javax.annotation.Resource;

import com.constans.AccountConstant;
import com.dao.account.AccountTransactionFlowInterAddDao;
import com.entity.account.AccountTransactionFlowInterAdd;
import com.manager.account.AccountTransactionFlowInterAddManager;
import com.tool.date.DateUtil;
import com.tool.generate.unique.GenerateUniqueUtil;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionFlowInterAddManagerImpl implements AccountTransactionFlowInterAddManager {

    @Resource
    private AccountTransactionFlowInterAddDao accountTransactionFlowInterDao;

    @Override
    public boolean addFlow(AccountTransactionFlowInterAdd accountTransactionFlowInter) {

        if(accountTransactionFlowInter==null){
            return false;
        }

        //todo  lock
        Integer tradeDay = DateUtil.getIntDateFormat(DateUtil.FORMAT_YYYYMMDD,accountTransactionFlowInter.getTradeDate());
        accountTransactionFlowInter.setTradeDay(tradeDay);
        int insert = accountTransactionFlowInterDao.insertSelective(accountTransactionFlowInter);
        if(insert==0){
            return false;
        }

        return true;
    }

    @Override
    public String getFlowNo() {
        String code = AccountConstant.FLOW_INTER_ADD_PREFIX+ GenerateUniqueUtil.getUuId()+"_"+DateUtil.getCurrentStr(DateUtil.FORMAT_YYYYMMDDHHMMSSSSS)+"_"+Thread.currentThread().getId();
        return code;
    }
}
