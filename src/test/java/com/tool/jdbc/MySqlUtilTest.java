package com.tool.jdbc;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import com.achilles.wild.server.tool.jdbc.MySqlUtil;

public class MySqlUtilTest {

	@Test
	public void getMapBysqlTest(){
		List<Map<String,Object>> map = MySqlUtil.getListBysql("select * from citizen order by id desc limit 1");
		System.out.println(map);
	}
}
