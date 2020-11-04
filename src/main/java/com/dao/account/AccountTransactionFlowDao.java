package com.dao.account;

import com.entity.account.AccountTransactionFlow;
import org.apache.ibatis.annotations.Param;

public interface AccountTransactionFlowDao {


    Integer selectVersionByAccountCode(@Param("accountCode") String accountCode, @Param("userId") String userId, @Param("tradeDay") Integer tradeDay);

    int insertSelective(AccountTransactionFlow record);

    String selectFlowNoByKey(@Param("idempotent") String idempotent, @Param("userId") String userId);
}