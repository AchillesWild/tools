package com.dao.account;

import java.util.List;

import com.entity.account.AccountRuleCollect;
import org.apache.ibatis.annotations.Param;

public interface AccountRuleCollectDao {

    int insertSelective(AccountRuleCollect record);


    List<AccountRuleCollect> selectRuleByUser( @Param("userId") String userId);

}