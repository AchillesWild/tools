package com.achilles.wild.server.biz;

import com.achilles.wild.server.model.request.account.BalanceRequest;
import com.achilles.wild.server.model.response.DataResult;
import com.achilles.wild.server.model.response.account.BalanceResponse;

public interface BalanceBiz {

    DataResult<BalanceResponse> reduce(BalanceRequest request);

    DataResult<String> add(BalanceRequest request);
}
