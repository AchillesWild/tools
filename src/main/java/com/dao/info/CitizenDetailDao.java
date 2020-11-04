package com.dao.info;

import com.entity.info.CitizenDetail;

public interface CitizenDetailDao {
    int deleteByPrimaryKey(Long id);

    int insert(CitizenDetail record);

    int insertSelective(CitizenDetail record);

    CitizenDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CitizenDetail record);
    
    int updateByUuidSelective(CitizenDetail record);

    int updateByPrimaryKey(CitizenDetail record);
}