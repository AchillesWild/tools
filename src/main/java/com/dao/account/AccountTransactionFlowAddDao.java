package com.dao.account;

import com.entity.account.AccountTransactionFlowAdd;
import org.apache.ibatis.annotations.Param;

public interface AccountTransactionFlowAddDao {

    int insertSelective(AccountTransactionFlowAdd record);


    String selectFlowNoByKey(@Param("idempotent") String idempotent, @Param("userId") String userId);
}