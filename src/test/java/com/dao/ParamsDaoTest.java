package com.dao;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;

import com.dao.info.ParamsDao;
import com.entity.info.Params;
import com.tool.BaseSpringJUnitTest;
import org.junit.Test;

public class ParamsDaoTest  extends BaseSpringJUnitTest {

    @Resource
    private ParamsDao paramsDao;

    @Test
    public void insert(){

        Params params = new Params();
        params.setCode("achilles"+System.currentTimeMillis());
        params.setVal("wild取值");
        int count = paramsDao.insert(params);

        Params params1 = paramsDao.selectByCode(params.getCode());



        System.out.println(JSON.toJSONString(params1));

    }


    @Test
    public void updateByCode(){


       int count = paramsDao.updateByCode("wer","阿基里斯");

        System.out.println();
    }

}