package com.manager.account;

import com.entity.account.AccountTransactionFlow;

public interface AccountTransactionFlowManager {

    boolean addFlow(AccountTransactionFlow accountTransactionFlow);


    String getFlowNoByKey(String key,String userId);
}
