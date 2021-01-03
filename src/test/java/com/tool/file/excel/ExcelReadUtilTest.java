package com.tool.file.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.achilles.wild.server.tool.file.excel.ExcelReadUtil;
import com.achilles.wild.server.tool.file.excel.ExcelWriteUtil;
import com.achilles.wild.server.tool.jdbc.MySqlUtil;
import com.achilles.wild.server.tool.jdbc.SqlUtil;

/**
 * 数据库与excel数据互读互写
 * @author Pang
 *
 */
public class ExcelReadUtilTest {

	private final static Logger log =LoggerFactory.getLogger(ExcelReadUtilTest.class);
	
	/**
	 * 把excel数据写的数据库
	 */
	@Test
	public void readExcelToList() {
		//1.读取excel数据-------------------------------------------------
		String url = "C://Users//Administrator//Desktop//a.xlsx";
//		 String url = "C://Users//Achil//Desktop//a.xls";
		 List<Map<String,Object>> mapList = ExcelReadUtil.readExcelForList(url,2,new Integer[]{2,4});
		 for (Map<String, Object> map : mapList) {
			 log.info(map.toString());
		}
		log.info("---------------总数-------"+mapList.size());
	}
	
	/**
	 * 把数据库数据写入excel
	 */
	public static void readDBToExcel() {
		//1.读取数据库数据-------------------------------------------------
		String sql = "select * from lcs_member";
		List<Map<String,Object>> dataList=MySqlUtil.getListBysql(sql);
		//2.将读取的数据库数据写入excel----------------------------------------
		 String url = "C://Users//Administrator//Desktop//数据库到excel.xlsx";
		 boolean flag= ExcelWriteUtil.write(url,dataList);
		 System.out.println(flag);
	}
	
	/**
	 * 把excel数据写的数据库
	 */
	@Test
	public void readExcelToDB() {
		//1.读取excel数据-------------------------------------------------
		 String url = "C://Users//Administrator//Desktop//a.xlsx";
//		 String url = "C://Users//Achil//Desktop//a.xls";
		 Map<Integer,String> columnToFieldMap = new HashMap<Integer,String>();//excel 需要的列和 数据库字段对应
		 columnToFieldMap.put(2, "remark");
		 columnToFieldMap.put(4, "mobile");
		 List<Map<String,Object>> mapList = ExcelReadUtil.readExcelForList(url,2,columnToFieldMap);
		//2.将读取的excel数据插入数据库----------------------------------------
		 List<String> sqlList = new ArrayList<String>();
		 for (int i = 0; i < mapList.size(); i++) {
			String insertSql = SqlUtil.getInsertSql("wl_lcs.lcs_sms", mapList.get(i));
			sqlList.add(insertSql);
		 }
		 String val = MySqlUtil.updateBatch(sqlList);
		 System.out.println(val);
	}
	
	@Test
	public void rreadExcelForSetTest() {
		String url = "C://Users//Administrator//Desktop//a.xlsx";
		System.out.println(ExcelReadUtil.readExcelForSet(url,2,2).toString());
	}
	
	
	@Test
	public void readExcelAllTest() {
		String url = "C://Users//Achil//Desktop//a.xlsx";
		System.out.println(ExcelReadUtil.readExcelAll(url));
	}
}
