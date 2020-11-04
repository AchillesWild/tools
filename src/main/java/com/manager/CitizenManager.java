package com.manager;

import java.util.List;

import com.entity.info.Citizen;
import com.model.query.CitizenQuery;

public interface CitizenManager {

	List<Citizen> addCitizens(List<Citizen> list);

	List<Citizen>  getListPage(CitizenQuery query);


	List<Citizen>  getCitizenPage(CitizenQuery query);
}
