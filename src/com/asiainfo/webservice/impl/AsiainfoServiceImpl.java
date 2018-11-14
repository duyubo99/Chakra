package com.asiainfo.webservice.impl;

import java.util.HashMap;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.service.OtherService;
import com.asiainfo.service.SqlService;
import com.asiainfo.webservice.AsiainfoService;
@Service("asiainfoService")
public class AsiainfoServiceImpl implements
	AsiainfoService {
	@Resource
	private OtherService otherService;
	
	@Resource
	private SqlService sqlService;
	
	@Override
	public String queryText(String no,Map<String,String> sqlsParams){
		Map<String, String> sqls=new HashMap<String,String>();
		String text = otherService.queryTextByNo(no, sqls);
		return sqlService.convertJsonPar2Jsontext(text,sqls,sqlsParams);
	}

}
