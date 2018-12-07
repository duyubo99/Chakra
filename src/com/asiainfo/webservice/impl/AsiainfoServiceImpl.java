package com.asiainfo.webservice.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.service.OtherService;
import com.asiainfo.service.SqlService;
import com.asiainfo.util.ParamSort;
import com.asiainfo.webservice.AsiainfoService;
@Service("asiainfoService")
public class AsiainfoServiceImpl implements
	AsiainfoService {
	@Resource
	private OtherService otherService;
	
	@Resource
	private SqlService sqlService;
	/**
	 * {2=select * from other_test_data where t1!=? and t2!=?, 1=select * from other_test_data where t1!=? and t2!=?}
	 * {2=1@2, 1=1@2}
	 * {2=t1:1@t2:2, 1=t1:1@t2:2}
	 */
	@Override
	public String queryText(String no,Map<String,String> sqlsParams){
		Map<String,String> sqlsParamsNew = new HashMap<String,String>();
		Map<String, String> sqls=new HashMap<String,String>();
		String text = otherService.queryTextByNo(no, sqls);
		for(String key:sqlsParams.keySet()){
			String param = sqlsParams.get(key);
			String sql = sqls.get(key);
			if(sql==null){
				return "error:not key:【"+key+"】";
			}
			if(param.indexOf("=")==-1){
				return sqlService.convertJsonPar2Jsontext(text,sqls,sqlsParams);
			}
			String[] kvParams = param.split("@");
			Map<String,String> map = new HashMap<String,String>();
			for (String str : kvParams) {
				String[] kvParam = str.split("=");
				String field = kvParam[0];
				String val = kvParam[1];
				map.put(field, val);
			}
			ArrayList<ParamSort> fieldList = new ArrayList<ParamSort>();
			for(String field:map.keySet()){
				int index = sql.indexOf(field);
				if(index==-1){
					return "error:not field:【"+field+"】 ";
				}
				ParamSort ps = new ParamSort(index,map.get(field));
				fieldList.add(ps);
			}
			Iterator<ParamSort> iterator=fieldList.iterator();
	        Collections.sort(fieldList);
	        String sqlsParamsStr="";
	        while(iterator.hasNext()){
	        	ParamSort s=iterator.next();
	        	sqlsParamsStr+=s.getVal()+"@";
	        }
	        sqlsParamsStr=sqlsParamsStr.substring(0,sqlsParamsStr.length()-1);
	        sqlsParamsNew.put(key, sqlsParamsStr);
		}
		return sqlService.convertJsonPar2Jsontext(text,sqls,sqlsParamsNew);
	}

}
