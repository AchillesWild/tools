package com.dao.account;

import java.util.List;

import com.entity.account.AccountRulePay;
import org.apache.ibatis.annotations.Param;

public interface AccountRulePayDao {

    int insertSelective(AccountRulePay record);


    List<AccountRulePay> selectRuleByUser( @Param("userId") String userId);

}