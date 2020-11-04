package com.manager.account;

import com.entity.account.AccountTransactionFlowInterAdd;

/**
 * flow
 */
public interface AccountTransactionFlowInterAddManager {

    boolean addFlow(AccountTransactionFlowInterAdd accountTransactionFlow);


    String getFlowNo();
}
