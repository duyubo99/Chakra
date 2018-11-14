package com.asiainfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.domain.cell.DataDes;
import com.asiainfo.domain.chart.Pie;
import com.asiainfo.domain.component.Serie;
import com.asiainfo.domain.component.Title;
import com.asiainfo.domain.component.Tooltip;
import com.asiainfo.hdao.BaseDao;
import com.asiainfo.service.PieService;
import com.asiainfo.util.DataUtil;
import com.asiainfo.util.DataUtil.DataCallback;
import com.asiainfo.util.ValidateUtil;
import com.asiainfo.vo.cell.DataDesVo;
import com.asiainfo.vo.chart.pie.PieVo;
import com.asiainfo.vo.component.serie.SerieDataVo;

@Service("pieService")
public class PieServiceImpl implements
	PieService {

	@Resource(name="pieDao")
	private BaseDao<Pie> pieDao;
	
	@Resource(name="serieDao")
	private BaseDao<Serie> serieDao;
	
	@Resource(name="titleDao")
	private BaseDao<Title> titleDao;
	
	@Resource(name="dataDesDao")
	private BaseDao<DataDes> dataDesDao;
	
	@Resource(name="tooltipDao")
	private BaseDao<Tooltip> tooltipDao;
	/**
	 * 保存饼图
	 */
	public void savePie(PieVo vo) {
		Pie model = new Pie();
		if(vo.getTitle() != null){
			Title t = DataUtil.voToModel(vo.getTitle());
			titleDao.saveEntity(t);
			model.setTitleId(t.gettId());
		}
		if(ValidateUtil.isValid(vo.getSeries())){
			String str = "";
			List<SerieDataVo> series = vo.getSeries();
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
		if(vo.getTooltip()!=null){
			Tooltip tVo = DataUtil.voToModel(vo.getTooltip());
			tooltipDao.saveEntity(tVo);
			model.setTooltipId(tVo.gettId());
		}
		pieDao.saveEntity(model);
	}

	/**
	 * 加载饼图
	 */
	public PieVo loadPie(int i) {
		PieVo vo = new PieVo();
		Pie entity = pieDao.getEntity(i);
		if(entity.getTitleId()!=null){
			Title t = titleDao.getEntity(entity.getTitleId());
			vo.setTitle(DataUtil.modelToVo(t));
		}
		if(entity.getSeriesIdsStr()!=""){
			String[] sIds = entity.getSeriesIdsStr().split(",");
			List<SerieDataVo> sds = new ArrayList<SerieDataVo>();
			for (String sId : sIds) {
				Serie serie = serieDao.getEntity(Integer.parseInt(sId));
				SerieDataVo dataVo = DataUtil.modelToDataVo(serie,new DataCallback() {
					@Override
					public String saveDataDes(List<DataDesVo> list) {
						return null;
					}
					@Override
					public DataDes getDataDes(int i) {
						return dataDesDao.getEntity(i);
					}
				});
				sds.add(dataVo);
			}
			vo.setSeries(sds);
		}
		if(entity.getTooltipId()!=null){
			Tooltip tooltip = tooltipDao.getEntity(entity.getTooltipId());
			vo.setTooltip(DataUtil.modelToVo(tooltip));
		}
		return vo;
	}
}
