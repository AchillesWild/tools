package com.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import com.entity.info.Citizen;
import com.entity.info.CrmClient;
import com.entity.info.LcsMember;
import com.model.query.CitizenQuery;
import com.model.response.DataResult;

public interface CitizenService {

	void addCitizen(JSONObject jsonOb);
	
	void addCitizen(LcsMember member);
	
	void addCitizen(CrmClient crmClient);

	Citizen addCitizen();
	
	List<Citizen> addCitizenList(List<Citizen> list);
	
	List<Citizen> addCitizens(List<Citizen> list);

	boolean saveCitizens(List<Citizen> list);

	DataResult<List<Citizen>> getList(CitizenQuery query);

	DataResult<List<Citizen>> getCitizens(CitizenQuery query);
	
}
