package com.design.proxy.staticc;

import java.util.List;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;

import com.entity.info.Citizen;
import com.entity.info.CrmClient;
import com.entity.info.LcsMember;
import com.model.query.CitizenQuery;
import com.model.response.DataResult;
import com.service.CitizenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Service
public class CitizenProxyServiceImpl implements CitizenService {

    private final static Logger LOG = LoggerFactory.getLogger(CitizenProxyServiceImpl.class);


    @Resource
    private CitizenService citizenService;


    @Override
    public void addCitizen(JSONObject jsonOb) {

    }

    @Override
    public void addCitizen(LcsMember member) {

    }

    @Override
    public void addCitizen(CrmClient crmClient) {

    }

    @Override
    public Citizen addCitizen() {
        return null;
    }

    @Override
    public List<Citizen> addCitizenList(List<Citizen> list) {
        return null;
    }

    @Override
    public List<Citizen> addCitizens(List<Citizen> list) {
        return null;
    }

    @Override
    public boolean saveCitizens(List<Citizen> list) {
        return false;
    }

    @Override
    public DataResult<List<Citizen>> getList(CitizenQuery query) {
        return null;
    }

    @Override
    public DataResult<List<Citizen>> getCitizens(CitizenQuery query) {

        LOG.info("get citizen proxy  start =====================================");

        DataResult<List<Citizen>> list = citizenService.getCitizens(query);


        LOG.info("get citizen proxy  over =====================================");

        return list;
    }
}
