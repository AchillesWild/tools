package com.manager.account.atom;

import com.entity.account.AccountInter;

public interface AccountInterAtomManager {

    AccountInter getPayAccountInter(String userId,Long amount);


    AccountInter mergeInterBalance(String userId,Integer accountType,Long amount);


    boolean reduceInterBalance(Long id,Long amount);
}
