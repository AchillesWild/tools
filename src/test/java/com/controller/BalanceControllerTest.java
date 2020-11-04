package com.controller;

import java.util.Date;
import java.util.concurrent.ExecutorService;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import com.model.request.account.BalanceRequest;
import com.model.response.DataResult;
import com.tool.BaseSpringJUnitTest;
import com.tool.ThreadUtil;
import com.tool.date.DateUtil;
import com.tool.generate.unique.GenerateUniqueUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BalanceControllerTest extends BaseSpringJUnitTest {

    private final static Logger LOG = LoggerFactory.getLogger(BalanceControllerTest.class);


    @Resource
    private BalanceController balanceController;

    //private static ExecutorService poolExecutor = ThreadUtil.getExecutor(2,9,10);


    @Test
    public void reduce2(){

        long start = DateUtil.getCurrentDate().getTime();
        for(Integer i=1;i<=1;i++) {
            BalanceRequest request = getBalanceRequest();
            DataResult result = balanceController.reduce(request);
            LOG.info("===============================================result:     "+JSON.toJSONString(result));
        }
        long end = DateUtil.getCurrentDate().getTime();
        LOG.info("******************************************      "+(end-start)/1000);
    }

    private BalanceRequest getBalanceRequest() {
        BalanceRequest request = new BalanceRequest();
        request.setUserId("wild");
        request.setKey(GenerateUniqueUtil.getUuId());
        //request.setKey("9E6DA17F33474CAEA94482D3801EDEB1");
        request.setAmount(10L);
        request.setTradeDate(new Date());
        return request;
    }

    @Test
    public void reduce() throws Exception{

        for(Integer i=1;i<=1010;i++) {
            new Thread() {
                public void run() {
                    BalanceRequest request = getBalanceRequest();
                    DataResult result = balanceController.reduce(request);
                    LOG.info("THREAD    :   "+Thread.currentThread().getId()+" ~~~~~~~~~~~~~~~~~~~~~  "+ JSON.toJSONString(result));
                }
            }.start();
        }
        Thread.sleep(25000l);
    }


    @Test
    public void add() throws Exception{

        long start = DateUtil.getCurrentDate().getTime();
        for(Integer i=1;i<=1000;i++) {
            new Thread() {
                public void run() {
                    BalanceRequest request = getBalanceRequest();
                    DataResult result = balanceController.add(request);
                    //LOG.info("线程:"+Thread.currentThread().getId()+" ~~~~~~~~~~~~~~~~~~~~~  "+ JSON.toJSONString(result));
                //
                }

                ;
            }.start();
        }
        long end = DateUtil.getCurrentDate().getTime();
        Thread.sleep(21000l);
        //LOG.info("******************************************      "+(end-start)/1000);
    }


}