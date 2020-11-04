package com.manager.account.atom;

import com.entity.account.Account;

public interface AccountAtomManager {


    Account getPayAccount(String userId,Long amount);

    /**
     * merge balance to one
     *
     * @param userId
     * @return
     */
    Account mergeBalance(String userId,Integer accountType,Long amount);


    boolean reduceBalance(Long id,Long amount);
}
