package com.dao.account;

import java.util.List;

import com.entity.account.AccountLock;
import org.apache.ibatis.annotations.Param;

public interface AccountLockDao {


    int insertSelective(AccountLock record);

    AccountLock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountLock record);

    List<AccountLock> selectLockAccount(@Param("accountCode") String accountCode);

    int unlockAll();

}