package com.service.account;

import com.model.request.account.BalanceRequest;
import com.model.response.DataResult;

/**
 * �ո���
 */
public interface BalanceService {


    //DataResult<String> addUserBalance(BalanceRequest request);

    DataResult<String> consumeUserBalance(BalanceRequest request);

    DataResult<String> addInterBalance(BalanceRequest request);

    DataResult<String> consumeInterBalance(BalanceRequest request);


    Long getBalance(String userId);

    Long getInterBalance();

}
