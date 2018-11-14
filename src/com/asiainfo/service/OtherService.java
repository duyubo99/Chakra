package com.asiainfo.service;

import java.util.Map;

import com.asiainfo.domain.other.Jsontext;
import com.asiainfo.domain.other.Sqltext;
import com.asiainfo.util.MyPage;


public interface OtherService{
	void saveJsontext(Jsontext model);
	
	void saveSqlText(Sqltext model);
	
	/**
	 * 根据id读取数据库中的图表
	 */
	Object[] readEchartById(Integer id);
	/**
	 * 保存图表
	 */
	void saveText(Jsontext jsonText,
			Map<String, String> sqls, Map<String, String> sqlsParams);
	/**
	 * 更新图表
	 * @param i 
	 * @param isValid 
	 */
	void updateText(Jsontext jt, Map<String, String> sqls,
			Map<String, String> sqlsParams);
	/**
	 * 分页查询
	 */
	void findJsonTextListByPage(MyPage<Jsontext> page);
	/**
	 * 根据业务编号反回echart文本
	    Map<String, String> maps=new HashMap<String,String>();
		maps.put("1", "1@2");
		String text = asiainfoService.queryText("A50001", maps);
		System.out.println(text);
	 * @param no
	 * @param sqls
	 * @return
	 */
	String queryTextByNo(String no,Map<String, String> sqls);
}
