package com.achilles.wild.server.manager;

import javax.annotation.Resource;

import com.achilles.wild.server.constans.AccountConstant;
import com.achilles.wild.server.manager.account.atom.AccountLockAtomManager;
import com.achilles.wild.server.tool.BaseSpringJUnitTest;
import org.junit.Test;

public class AccountLockManagerTest extends BaseSpringJUnitTest {


    @Resource
    private AccountLockAtomManager accountLockManager;


    @Test
    public void unlockAllAccount(){
        boolean ret = accountLockManager.unlockAll();
        System.out.println(ret);
    }

    @Test
    public void unLock(){
        boolean ret = accountLockManager.unLock("AEF7DD2BF46244BF913783C9ECF9A2D3_20200530184618331_4");
        System.out.println(ret);
    }

    @Test
    public void lock(){
        boolean ret = accountLockManager.lock("PAY_ACCOUNT_2", AccountConstant.ACCOUNT_INTER_USER_ID,38);
        System.out.println(ret);
    }
}
