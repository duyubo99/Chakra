package com.asiainfo.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.asiainfo.domain.other.Jsontext;
import com.asiainfo.domain.other.Sqltext;
import com.asiainfo.hdao.BaseDao;
import com.asiainfo.service.OtherService;
import com.asiainfo.util.MyPage;

@Service("otherService")
public class OtherServiceImpl implements
	OtherService {

	@Resource(name="jsontextDao")
	private BaseDao<Jsontext> jsontextDao ;
	
	
	@Resource(name="sqltextDao")
	private BaseDao<Sqltext> sqltextDao ;
	
	@Override
	public void saveJsontext(Jsontext model) {
		jsontextDao.saveOrUpdateEntity(model);
	}

	@Override
	public void saveSqlText(Sqltext model) {
		sqltextDao.saveEntity(model);
	}


	public void saveSqlByUuid(List<Sqltext> sqls) {
		if(sqls!=null&&sqls.size()!=0){
			for (Sqltext sqltext : sqls) {
				this.saveSqlText(sqltext);
			}
		}
	}
	@Override
	public void saveText(Jsontext jsonText,
			Map<String, String> sqls, Map<String, String> sqlsParams) {
		LinkedList<Sqltext> sqlsText = new LinkedList<Sqltext>();
		String uuid = UUID.randomUUID().toString();
		jsonText.setUuid(uuid);
		jsontextDao.saveEntity(jsonText);
		if(sqls!=null&&sqls.size()!=0){
			Sqltext sqltext;
			for(String key:sqls.keySet()){
				sqltext = new Sqltext();
				sqltext.setUuid(uuid);
				sqltext.setSqlStr(sqls.get(key));
				if(sqlsParams!=null&&sqlsParams.size()!=0){
					if(sqlsParams.get(key)!=null&&!sqlsParams.get(key).equals("")){
						sqltext.setParStr(sqlsParams.get(key));
					}
				}
				sqltext.setKeyStr(key);
				sqlsText.add(sqltext);
			}
			this.saveSqlByUuid(sqlsText);
		}
	}

	@Override
	public Object[] readEchartById(Integer id) {
		Jsontext entity = jsontextDao.getEntity(id);
		List<Sqltext> sqltexts = sqltextDao.findEntityByHQL("FROM Sqltext s where s.uuid=? order by s.keyStr",entity.getUuid());
		String params = "";
		if(sqltexts!=null&&sqltexts.size()!=0){
			for (int i = 0; i < sqltexts.size(); i++) {
				Sqltext sqltext = sqltexts.get(i);
				params = params+(sqltext.getKeyStr()+"," + sqltext.getSqlStr()+
						(sqltext.getParStr()!=null&&!sqltext.getParStr().equals("")?
								","+sqltext.getParStr():"")+";");
			}
		}
		return new Object[]{entity,params};
	}

	@Override
	public void updateText(Jsontext jt, Map<String, String> sqls,
			Map<String, String> sqlsParams) {
		Jsontext jsonText= jsontextDao.getEntity(jt.getjId());
		jsonText.setDescText("hello");
		jt.setUuid(jsonText.getUuid());
		BeanUtils.copyProperties(jt, jsonText);
		jsontextDao.updateEntity(jsonText);
		sqltextDao.batchEntityByHQL("DELETE FROM Sqltext s where s.uuid=?",jsonText.getUuid());
		LinkedList<Sqltext> sqlsText = new LinkedList<Sqltext>();
		if(sqls!=null&&sqls.size()!=0){
			Sqltext sqltext;
			for(String key:sqls.keySet()){
				sqltext = new Sqltext();
				sqltext.setUuid(jsonText.getUuid());
				sqltext.setSqlStr(sqls.get(key));
				if(sqlsParams!=null&&sqlsParams.size()!=0){
					if(sqlsParams.get(key)!=null&&!sqlsParams.get(key).equals("")){
						sqltext.setParStr(sqlsParams.get(key));
					}
				}
				sqltext.setKeyStr(key);
				sqlsText.add(sqltext);
			}
			this.saveSqlByUuid(sqlsText);
		}
	}

	@Override
	public void findJsonTextListByPage(MyPage<Jsontext> page) {
		StringBuffer hql = new StringBuffer("FROM Jsontext j where 1=1");
		if(page.getQueryModel()!=null){
			Jsontext query = page.getQueryModel();
			if(query.getBusNo()!=null){
				hql.append(" and busNo like '%"+query.getBusNo()+"%'");
			}
			if(query.getDescText()!=null){
				hql.append(" and descText like '%"+query.getDescText()+"%'");
			}
		}
		if(page.getSort()!=null&&!page.getSort().equals("")){//排序
			hql.append(" order by "+page.getSort()+" "+page.getOrder());
		}
		jsontextDao.findEntityByHQLPage(page, hql.toString());
	}
	
	public String queryTextByNo(String no,Map<String, String> sqls) {
		Jsontext entity = (Jsontext) jsontextDao.uniqueResult("FROM Jsontext j where j.busNo=?", no);
		if(entity!=null && entity.getJsonStr()!=null && 
				!entity.getJsonStr().equals("")){
			List<Sqltext> sqltexts = sqltextDao.findEntityByHQL("FROM Sqltext s where s.uuid=? order by s.keyStr",entity.getUuid());
			if(sqltexts!=null&&sqltexts.size()!=0){
				for (int i = 0; i < sqltexts.size(); i++) {
					Sqltext sqltext = sqltexts.get(i);
					sqls.put(sqltext.getKeyStr(), sqltext.getSqlStr());
				}
			}
			return entity.getJsonStr();
		}
		return "";
	}

}
