package com.dao.account;

import com.entity.account.AccountSummary;

public interface AccountSummaryDao {

    int deleteByPrimaryKey(Long id);

    int insert(AccountSummary record);

    int insertSelective(AccountSummary record);

    AccountSummary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountSummary record);

    int updateByPrimaryKey(AccountSummary record);
}