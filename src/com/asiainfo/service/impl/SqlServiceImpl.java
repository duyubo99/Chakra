package com.asiainfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.domain.Sqltext;
import com.asiainfo.hdao.BaseDao;
import com.asiainfo.service.SqlService;
import com.asiainfo.util.DynamicDataSourceHolder;
import com.asiainfo.util.OtherStringUtil;
import com.asiainfo.util.StringUtil;

@Service("sqlService")
public class SqlServiceImpl implements
	SqlService {

	@Resource(name="sqltextDao")
	private BaseDao<Sqltext> sqltextDao ;
	/**
	 * {2=select * from other_test_data where t1!=? and t2!=?, 1=select * from other_test_data where t1!=? and t2!=?}
	 * {2=1@2, 1=1@2}
	 */
	@Override
	public String convertJsonPar2Jsontext(String text, Map<String,String> sqls
			,Map<String,String> sqlsParams) {
		Map<String, List<Integer>> str2Map = OtherStringUtil.str2Map(text);
		Map<String, String> map = new HashMap<String,String>();
		List<Object[]> querys = null;
		for(String key:str2Map.keySet()){
			String sql = sqls.get(key);
			List<Integer> list = str2Map.get(key);
			try {
				if(sqlsParams.get(key)!=null){
					querys = sqltextDao.findEntityBySQL2(sql,
							sqlsParams.get(key).split("@"));
				}else{
					querys = sqltextDao.findEntityBySQL(sql);
				}
			} catch (Exception e) {
				DynamicDataSourceHolder.removeRouteKey();
				return text;
			}
			for (Integer id : list) {
				Object[] objects = querys.get(id-1);
				map.put(key+"_"+id, StringUtil.arr2Str(objects, ",","'"));
			}
		}
		for(String s:map.keySet()){
//			System.out.println("key : "+s+" value : "+map.get(s));
			text=text.replaceAll("@"+s+"@", map.get(s));
		}
		DynamicDataSourceHolder.removeRouteKey();
		return text;
	}

}
