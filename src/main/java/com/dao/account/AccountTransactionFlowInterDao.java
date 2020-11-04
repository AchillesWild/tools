package com.dao.account;

import com.entity.account.AccountTransactionFlowInter;
import org.apache.ibatis.annotations.Param;

public interface AccountTransactionFlowInterDao {

    Integer selectVersionByAccountCode(@Param("accountCode") String accountCode, @Param("userId") String userId,
        @Param("tradeDay") Integer tradeDay);

    int insertSelective(AccountTransactionFlowInter record);


    String selectFlowNoByKey(@Param("idempotent") String idempotent, @Param("userId") String userId);

}