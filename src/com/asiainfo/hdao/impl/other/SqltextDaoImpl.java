package com.asiainfo.hdao.impl.other;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asiainfo.domain.other.Sqltext;
import com.asiainfo.hdao.impl.BaseDaoImpl;
import com.asiainfo.util.DynamicDataSourceHolder;

@Repository("sqltextDao")
public class SqltextDaoImpl extends BaseDaoImpl<Sqltext> {
	public List<Object[]> findEntityBySQL(String sql,Object...objects){
		DynamicDataSourceHolder.setRouteKey(DynamicDataSourceHolder.DATA_SOURCE_B);
		return super.findEntityBySQL(sql, objects);
	}
	public List<Object[]> findEntityBySQL2(String sql,Object[] objects){
		DynamicDataSourceHolder.setRouteKey(DynamicDataSourceHolder.DATA_SOURCE_B);
		return super.findEntityBySQL2(sql, objects);
	}
}
