package com.manager.account.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.cache.AcountLock;
import com.constans.AccountConstant;
import com.dao.account.AccountDao;
import com.dao.account.AccountRuleCollectDao;
import com.entity.account.Account;
import com.entity.account.AccountRuleCollect;
import com.entity.account.AccountRulePay;
import com.enums.StatusEnum;
import com.enums.account.AccountTypeEnum;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.manager.account.AccountManager;
import com.manager.account.atom.AccountAtomManager;
import com.model.query.account.AccountQuery;
import com.tool.date.DateUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountManagerImpl implements AccountManager {

    private final static Logger LOG = LoggerFactory.getLogger(AccountManagerImpl.class);

    @Resource
    private AccountDao accountDao;

    @Resource
    private AccountRuleCollectDao accountRuleCollectDao;

    @Resource
    private AccountAtomManager accountAtomManager;

    private static Cache<String,List<AccountRuleCollect>> collectRuleCache = CacheBuilder.newBuilder().concurrencyLevel(1000).maximumSize(20000).expireAfterWrite(5, TimeUnit.SECONDS).build();


    private static Cache<String,List<AccountRulePay>> payRuleCache = CacheBuilder.newBuilder().concurrencyLevel(1000).maximumSize(20000).expireAfterWrite(5, TimeUnit.SECONDS).build();

    @Override
    public boolean addAccount(Account account) {
        if(account==null){
            return false;
        }

        int insert = accountDao.insertSelective(account);
        if(insert==0){
            return false;
        }

        return true;
    }

    @Override
    public boolean ifExist(AccountQuery query) {

        if(query==null){
            query = new AccountQuery();
        }

        query.setStatus(StatusEnum.NORMAL.toNumbericValue());

        long count = accountDao.selectCount(query);
        if(count!=0){
            return true;
        }

        return false;
    }

    @Override
    public boolean addAccounts(List<Account> accounts) {

        if(CollectionUtils.isEmpty(accounts)){
            return false;
        }

        for (int i = 0; i < accounts.size(); i++) {
            String code = AccountConstant.ACCOUNT_PREFIX+DateUtil.getCurrentStr(DateUtil.FORMAT_YYYYMMDDHHMMSSSSS)+"_"+Thread.currentThread().getId()+"_"+i;
            accounts.get(i).setAccountCode(code);
        }


        accountDao.batchInsert(accounts);

        return true;
    }

    @Override
    public String getAccountCode(Integer accountType) {

        if(accountType==null){
            return null;
        }

        if(!AccountTypeEnum.contains(accountType)){
            return null;
        }

        String code = AccountConstant.ACCOUNT_PREFIX+DateUtil.getCurrentStr(DateUtil.FORMAT_YYYYMMDDHHMMSSSSS)+"_"+Thread.currentThread().getId()+"_";

        return code;
    }

    @Override
    public Account getBalanceByCode(String accountCode,String userId) {

        if(StringUtils.isEmpty(accountCode)){
            return null;
        }

        Account account = accountDao.selectAccountByCode(accountCode,userId);

        return account;
    }


    @Override
    public boolean updateBalanceById(Long id, Long amount) {

        if(id==null||id==0||amount==null||amount<=0){
            return false;
        }

        int update =accountDao.updateBalanceById(id,amount);
        if(update==0){
            return false;
        }

        return true;
    }

    @Override
    public boolean updateUserBalanceById(Long id, Long balance) {

        if(id==null||id==0||balance==null||balance<0){
            return false;
        }

        int update =accountDao.updateUserBalanceById(id,balance);
        if(update==0){
            return false;
        }

        return true;
    }

    @Override
    public Long getUserBalance(String userId) {

        if(StringUtils.isEmpty(userId)){
            return 0L;
        }

        Long balance = accountDao.selectUserBalance(userId);

        return balance==null?0L:balance;
    }

    @Override
    public Account getCollectAccount(String userId) {

        if(StringUtils.isEmpty(userId)){
            return null;
        }

        List<AccountRuleCollect> accountRuleCollects= collectRuleCache.getIfPresent(AccountConstant.ACCOUNT_COLLECT_RULE+userId);
        if(CollectionUtils.isEmpty(accountRuleCollects)){
            accountRuleCollects = accountRuleCollectDao.selectRuleByUser(userId);
        }

        if(CollectionUtils.isEmpty(accountRuleCollects)){
            return null;
        }

        accountRuleCollects = accountRuleCollects.stream().sorted(Comparator.comparing(AccountRuleCollect::getWeight).reversed()).collect(Collectors.toList());

        AccountRuleCollect accountRuleColl = null;
        for(AccountRuleCollect accountRuleCollect:accountRuleCollects){
            if(AcountLock.lock(accountRuleCollect.getAccountCode())){
                accountRuleColl = accountRuleCollect;
                break;
            }
        }

        if(accountRuleColl==null){
            Collections.shuffle(accountRuleCollects);
            accountRuleColl = accountRuleCollects.get(0);
        }

        Account account = accountDao.selectAccountByCode(accountRuleColl.getAccountCode(),userId);

        return account;
    }

    @Override
    public Account getAccountById(Long id) {

        if(id==null||id==0){
            return null;
        }

        return accountDao.selectById(id);
    }

    @Override
    public long getVersionById(Long id) {

        if(id==null||id==0){
            throw new IllegalArgumentException("id is null");
        }

        return accountDao.selectVersionById(id);
    }

    @Override
    public Account reduceUserBalance(String userId, Long amount) {

        if(StringUtils.isEmpty(userId)||amount==null||amount<=0){
            throw new IllegalArgumentException();
        }

        Account account = accountAtomManager.getPayAccount(userId,amount);
        if(account!=null){
            boolean updateBalance = accountAtomManager.reduceBalance(account.getId(),amount);
            if(updateBalance){
                return account;
            }
            throw new RuntimeException("reduceUserBalance reduceBalance fail");
        }

        account = accountAtomManager.mergeBalance(userId,AccountTypeEnum.PAY_ACCOUNT.toNumbericValue(),amount);
        if(account==null){
            throw new RuntimeException("reduceUserBalance get user Account null  after mergeBalance");
        }
        boolean updateBalance = accountAtomManager.reduceBalance(account.getId(),amount);
        if(!updateBalance){
            throw new RuntimeException("reduceUserBalance fail  after mergeBalance");
        }

        account.setBalance(account.getBalance()-amount);

        return account;
    }
}
