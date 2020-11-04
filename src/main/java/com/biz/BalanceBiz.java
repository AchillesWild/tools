package com.biz;

import com.model.request.account.BalanceRequest;
import com.model.response.DataResult;
import com.model.response.account.BalanceResponse;

public interface BalanceBiz {

    DataResult<BalanceResponse> reduce(BalanceRequest request);

    DataResult<String> add(BalanceRequest request);
}
