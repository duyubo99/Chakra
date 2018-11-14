package com.asiainfo.service;

import java.util.Map;


public interface SqlService{
	
	String convertJsonPar2Jsontext(String text, Map<String,String> sqls,Map<String,String> sqlsParams);
}
