package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.Resource;

import com.entity.info.Citizen;
import com.service.CitizenService;
import com.service.impl.CitizenServiceImpl;
import com.tool.date.DateUtil;
import com.tool.generate.unique.GenerateUniqueUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallThread implements Callable<Integer> {

    private final static Logger LOG = LoggerFactory.getLogger(CallThread.class);

    private int m;

    public  CallThread(int m){
        this.m=m;
    }

    private CitizenService citizenService;

    public  CallThread(CitizenService citizenService,int m){
        this.citizenService=citizenService;
        this.m=m;
    }

    @Override
    public Integer call() throws Exception {

        LOG.info("********************  "+m);

        List<Citizen> list = new ArrayList<Citizen>();
        for (int i = 0; i < 10; i++) {
            Citizen citizen = new Citizen();
            String uuid = GenerateUniqueUtil.getUuId();
            citizen.setUuid(uuid);
            citizen.setName("wild"+System.currentTimeMillis()+i+m);
            citizen.setIdNo("94937537"+m+i);
            citizen.setRemark("test");
            citizen.setCreateDate(DateUtil.getCurrentDate());
            list.add(citizen);
        }
        citizenService.addCitizens(list);
        return 1;
    }
}
