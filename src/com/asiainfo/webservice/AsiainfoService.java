package com.asiainfo.webservice;

import java.util.Map;

/**
 * 远程服务
 * @author Mr.du
 */
public interface AsiainfoService {
	/**
	 * 查询echart文本
	 * 	
	 	Map<String, String> maps=new HashMap<String,String>();
		maps.put("1", "1@2");
		String text = asiainfoService.queryText("A50001", maps);
		System.out.println(text);
	 * @param no 业务编号
	 * @param sqlsParams 动态参数 key:"1" value:"1@2"
	 * @return
	 */
	public String queryText(String no,Map<String,String> sqlsParams);
}
