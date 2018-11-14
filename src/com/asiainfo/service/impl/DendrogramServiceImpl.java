package com.asiainfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.domain.cell.DataDes;
import com.asiainfo.domain.chart.Dendrogram;
import com.asiainfo.domain.component.Axis;
import com.asiainfo.domain.component.Serie;
import com.asiainfo.domain.component.Title;
import com.asiainfo.hdao.BaseDao;
import com.asiainfo.service.DendrogramService;
import com.asiainfo.util.DataUtil;
import com.asiainfo.util.DataUtil.DataCallback;
import com.asiainfo.util.StringUtil;
import com.asiainfo.util.ValidateUtil;
import com.asiainfo.vo.cell.DataDesVo;
import com.asiainfo.vo.chart.dendrogram.DendrogramDataDesVo;
import com.asiainfo.vo.chart.dendrogram.DendrogramVo;
import com.asiainfo.vo.chart.dendrogram.base.BaseDendrogramVo;
import com.asiainfo.vo.component.serie.SerieDataVo;
import com.asiainfo.vo.component.serie.SerieVo;

@Service("dendrogramService")
public class DendrogramServiceImpl implements
	DendrogramService {

	@Resource(name="dendrogramDao")
	private BaseDao<Dendrogram> dendrogramDao ;
	
	@Resource(name="axisDao")
	private BaseDao<Axis> axisDao;
	
	@Resource(name="serieDao")
	private BaseDao<Serie> serieDao;
	
	@Resource(name="titleDao")
	private BaseDao<Title> titleDao;
	
	@Resource(name="dataDesDao")
	private BaseDao<DataDes> dataDesDao;
	
	/**
	 * 保存树状图实体数据
	 */
	@Override
	public void saveDendrogram(BaseDendrogramVo vo) {
		Dendrogram model = new Dendrogram();
		Axis a;
		if(vo.getTitle()!=null){
			Title t = DataUtil.voToModel(vo.getTitle());
			titleDao.saveEntity(t);
			model.setTitleId(t.gettId());
		}
		if(vo.getxAxis()!=null){
			a = DataUtil.voToModel(vo.getxAxis());
			axisDao.saveEntity(a);
			model.setxAxisId(a.getaId());
		}
		if(vo.getyAxis()!=null){
			a = DataUtil.voToModel(vo.getyAxis());
			axisDao.saveEntity(a);
			model.setyAxisId(a.getaId());
		}
		if(vo instanceof DendrogramVo){
			DendrogramVo v = (DendrogramVo) vo;
			if(v.getSeries()!=null&&v.getSeries().size()!=0){
				String str = "";
				List<SerieVo> series = v.getSeries();
				Serie serie;
				for (int i = 0; i < series.size(); i++) {
					serie = DataUtil.voToModel(series.get(i));
					serieDao.saveEntity(serie);
					str = str + serie.getsId()+",";
				}
				str = str.substring(0,str.length()-1);
				model.setSeriesIdsStr(str);
			}
			model.setSeriesType(1);
		}
		if(vo instanceof DendrogramDataDesVo){
			DendrogramDataDesVo v = (DendrogramDataDesVo) vo;
			if(ValidateUtil.isValid(v.getSeries())){
				String str = "";
				List<SerieDataVo> series = v.getSeries();
				Serie serie;
				for (int i = 0; i < series.size(); i++) {
					serie = DataUtil.voToModel(series.get(i),new DataUtil.DataCallback() {
						@Override
						public String saveDataDes(List<DataDesVo> list) {
							String s = "";
							for (int j = 0; j < list.size(); j++) {
								DataDes model2 = DataUtil.voToModel(list.get(j));
								dataDesDao.saveEntity(model2);
								s = s + model2.getdId()+",";
							}
							s = s.substring(0, s.length()-1);
							return s;
						}

						@Override
						public DataDes getDataDes(int i) {
							return null;
						}
					});
					serieDao.saveEntity(serie);
					str = str + serie.getsId()+",";
				}
				str = str.substring(0,str.length()-1);
				model.setSeriesIdsStr(str);
			}
			model.setSeriesType(2);
		}
		
		dendrogramDao.saveEntity(model);
	}
	/**
	 * 加载树状图
	 * type:
	 * 	1-SerieVo
	 * 	2-SerieDataVo
	 */
	public BaseDendrogramVo loadDendrogram(int i) {
		Dendrogram entity = dendrogramDao.getEntity(i);
		if(entity.getSeriesType()==1){
			DendrogramVo vo = new DendrogramVo();;
			loadDendrogramData(entity,vo);
			if(entity.getSeriesIdsStr()!=null){
				String[] str2Arr = StringUtil.str2Arr(entity.getSeriesIdsStr(), ",");
				List<SerieVo> series = new ArrayList<SerieVo>();
				for (String sid : str2Arr) {
					Serie model = serieDao.getEntity(Integer.parseInt(sid));
					series.add(DataUtil.modelToVo(model));
				}
				vo.setSeries(series);
			}
			return vo;
		}else if(entity.getSeriesType() == 2){
			DendrogramDataDesVo vo = new DendrogramDataDesVo();
			loadDendrogramData(entity,vo);
			if(entity.getSeriesIdsStr()!=null){
				String[] str2Arr = StringUtil.str2Arr(entity.getSeriesIdsStr(), ",");
				List<SerieDataVo> seriesData = new ArrayList<SerieDataVo>();
				for (String sid : str2Arr) {
					Serie model = serieDao.getEntity(Integer.parseInt(sid));
					seriesData.add(DataUtil.modelToDataVo(model,new DataCallback() {
						@Override
						public String saveDataDes(List<DataDesVo> list) {
							return null;
						}
						@Override
						public DataDes getDataDes(int i) {
							return dataDesDao.getEntity(i);
						}
					}));
				}
				vo.setSeries(seriesData);
			}
			return vo;
		}
		return null;
	}
	
	private BaseDendrogramVo loadDendrogramData(Dendrogram entity,BaseDendrogramVo vo){
		if(entity.getTitleId()!=null){
			Title t = titleDao.getEntity(entity.getTitleId());
			vo.setTitle(DataUtil.modelToVo(t));
		}
		if(entity.getxAxisId()!=null){
			Axis model = axisDao.getEntity(entity.getxAxisId());
			vo.setxAxis(DataUtil.modelToVo(model));
		}
		if(entity.getyAxisId()!=null){
			Axis model = axisDao.getEntity(entity.getyAxisId());
			vo.setyAxis(DataUtil.modelToVo(model));
		}
		return vo;
	}
}
