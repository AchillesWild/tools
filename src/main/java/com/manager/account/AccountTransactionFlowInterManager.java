package com.manager.account;

import com.entity.account.AccountTransactionFlowInter;

public interface AccountTransactionFlowInterManager {

    Integer getVersionByAccountCode(String accountCode,String userId,Integer tradeDay);

    boolean addFlow(AccountTransactionFlowInter accountTransactionFlowInter);



    String getFlowNoByKey(String key,String userId);
}
