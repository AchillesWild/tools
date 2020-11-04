package com.dao.info;

import com.entity.info.Params;
import org.apache.ibatis.annotations.Param;

public interface ParamsDao {

    int insert(Params params);

    int updateByCode(@Param("code") String code, @Param("val") String val);

    Params selectByCode(String code);
}
